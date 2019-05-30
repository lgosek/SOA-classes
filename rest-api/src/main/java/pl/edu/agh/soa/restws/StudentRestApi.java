package pl.edu.agh.soa.restws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.io.FileUtils;
import pl.edu.agh.soa.model.Student;
import pl.edu.agh.soa.model.StudentManager;
import pl.edu.agh.soa.restauth.JWTTokenNeeded;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.File;
import java.net.URI;
import java.util.Base64;

@Path("/students")
@Produces("application/Json")
@Consumes("application/Json")
public class StudentRestApi{
    @Inject
    private StudentManager studentManager;

    private ObjectMapper mapper = new ObjectMapper();

    @GET
    @Path("{id}/firstname")
    public Response getStudentFirstName(@PathParam("id") int id){
        ObjectNode node = mapper.createObjectNode();
        try {
            node.put("firstName", this.studentManager.get(id).getFirstName());
            return Response.ok(node.toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}/firstname")
    @JWTTokenNeeded
    public Response setStudentFirstName(@PathParam("id") int id, String json){
        try {
            ObjectNode node = mapper.readValue(json, ObjectNode.class);
            String newName = node.get("firstName").asText();
            this.studentManager.get(id).setFirstName(newName);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("{id}/lastname")
    public Response getStudentLastName(@PathParam("id") int id){
        ObjectNode node = mapper.createObjectNode();
        try {
            node.put("lastName", this.studentManager.get(id).getLastName());
            return Response.ok(node.toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}/lastname")
    @JWTTokenNeeded
    public Response setStudentLastName(@PathParam("id") int id, String json){
        try {
            ObjectNode node = mapper.readValue(json, ObjectNode.class);
            String newLastName = node.get("lastName").asText();
            this.studentManager.get(id).setLastName(newLastName);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("{id}/number")
    public Response getStudentNumber(@PathParam("id") int id){
        ObjectNode node = mapper.createObjectNode();
        try {
            node.put("number", this.studentManager.get(id).getStudentNumber());
            return Response.ok(node.toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}/number")
    @JWTTokenNeeded
    public Response setStudentNumber(@PathParam("id") int id, String json){
        try {
            ObjectNode node = mapper.readValue(json, ObjectNode.class);
            int newNumber = node.get("number").asInt();
            this.studentManager.get(id).setStudentNumber(newNumber);
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("{id}/avatar")
    public Response getAvatar(@PathParam("id") int id){
        byte[] fileContent; // = new byte[0];
        ObjectNode node = mapper.createObjectNode();
        try {
            fileContent = FileUtils.readFileToByteArray(new File(studentManager.get(id).getAvatarFilename()));
            String encodedString = Base64.getEncoder().encodeToString(fileContent);

            node.put("encodedAvatar", encodedString);
            return Response.ok(node.toString()).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("{id}")
    public Response getStudent(@PathParam("id") int id){
        Student student = this.studentManager.get(id);
        if(student==null)
            return Response.status(Response.Status.NOT_FOUND).build();

        String returnJson;
        try {
            returnJson = mapper.writeValueAsString(student);
            return Response.ok(returnJson).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/")
    public Response getAllStudents(){
        //ObjectMapper mapper = new ObjectMapper();
        String returnJson;
        try {
            returnJson = mapper.writeValueAsString(this.studentManager.getStudents());
            return Response.ok(returnJson).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }


    @POST
    @Path("/")
    @ValidateOnExecution
    @JWTTokenNeeded
    public Response addStudent(@Valid Student student){
        //ObjectMapper mapper = new ObjectMapper();
        try {
            if(this.studentManager.addStudent(student)==0){
                //return Response.created(new URI("Added student")).build();
                return Response.created(new URI("http://localhost:8080/rest-api/students/"+Integer.toString(student
                        .getId())+"/"))
                        .build();
            }
            else
                return Response.status(Response.Status.CONFLICT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }


    @PUT
    @Path("{id}")
    @JWTTokenNeeded
    public Response editStudent(@PathParam("id") int id, @Valid Student newStudent){
        Student student = this.studentManager.get(id);
        if(student==null)
            return Response.status(Response.Status.NOT_FOUND).build();
        //ObjectMapper mapper = new ObjectMapper();
        try {
            if(student.getId()!=newStudent.getId() && this.studentManager.get(newStudent.getId())!=null)
                return Response.status(Response.Status.CONFLICT).build();
            this.studentManager.removeStudent(student);
            if(this.studentManager.addStudent(newStudent)==0)
                return Response.created(new URI("http://localhost:8080/rest-api/students/"+Integer.toString(student
                    .getId())+"/"))
                    .build();
            else
                return Response.status(Response.Status.CONFLICT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }

    @DELETE
    @Path("{id}")
    @JWTTokenNeeded
    public Response deleteStudent(@PathParam("id") int id){
        Student student = this.studentManager.get(id);
        if(student==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.studentManager.removeStudent(student);
        return Response.ok().build();
    }

}
