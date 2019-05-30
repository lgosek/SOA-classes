package pl.edu.agh.soa.restconnector;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import pl.edu.agh.soa.model.Student;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;


public class RestConnector {
    private final static String URLbase = "http://localhost:8080/rest-api/";

    public static void main (String[] args) {

        ResteasyClient client = new ResteasyClientBuilder().build();

//      list of students

        ResteasyWebTarget target = client.target(URLbase+"students/");
        Response response = target.request().get();


        List<Student> students = response.readEntity(new GenericType<LinkedList<Student>>() {});


        for (Student s:students) {
            System.out.println(s.getFirstName() + " " + s.getLastName());
        }
        response.close();

//        avatar


        target = client.target(URLbase + "students/0/avatar/");
        response = target.request().get();

        String returnJson = response.readEntity(String.class);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = null;
        try {
            node = mapper.readValue(returnJson, ObjectNode.class);
            String encodedAvatar = node.get("encodedAvatar").asText();

            byte[] fileContent = Base64.getDecoder().decode(encodedAvatar);

            FileUtils.writeByteArrayToFile(new File("/home/lukasz/Dokumenty/SOA/backup/soap/rest-connector/src/main/resources/avatar.jpg"), fileContent);

        } catch (IOException e) {
            e.printStackTrace();
        }


//        authorization

        node = mapper.createObjectNode();

        node.put("login", "user");
        node.put("password", "pass");

        String json = node.toString();
        target = client.target(URLbase + "login/");
        response =target.request().post(Entity.entity(json, MediaType.APPLICATION_JSON));

        String key = response.getHeaders().get("Authorization").get(0).toString();

        System.out.println(key);

//        calling method requiring authorization

        Student student = new Student(5, "Łukasz", "Gosek", 123458);

        try {
            json = mapper.writeValueAsString(student);
            target = client.target(URLbase + "students/");
            response = target.request().header("Authorization", key).post(Entity.entity(json, MediaType
                    .APPLICATION_JSON));

            System.out.println(response.getStatus());
            if(response.getStatus()!=200){
                System.out.println(response.readEntity(String.class));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        client.close();

    }
}
