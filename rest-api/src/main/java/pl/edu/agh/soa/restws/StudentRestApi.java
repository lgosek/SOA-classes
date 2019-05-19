package pl.edu.agh.soa.restws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.edu.agh.soa.model.Student;
import pl.edu.agh.soa.model.StudentManager;

import javax.inject.Inject;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/students")
@Produces("application/Json")
public class StudentRestApi{
    @Inject
    private StudentManager studentManager;

    @GET
    @Path("{id}/name")
    public String getStudentFirstName(@PathParam("id") int id){
        return this.studentManager.get(id).getFirstName();
    }

    @GET
    @Path("{id}")
    public Response getStudent(@PathParam("id") int id){
        Student student = this.studentManager.get(id);
        if(student==null)
            return Response.status(Response.Status.NOT_FOUND).build();

        ObjectMapper mapper = new ObjectMapper();
        String returnJson = "";
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
        ObjectMapper mapper = new ObjectMapper();
        String returnJson = "";
        try {
            returnJson = mapper.writeValueAsString(this.studentManager);
            return Response.ok(returnJson).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }


    @POST
    @Path("/")
    @Consumes("application/Json")
    @ValidateOnExecution
    public Response addStudent(String json){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student student = mapper.readValue(json, Student.class);
            if(this.studentManager.addStudent(student)==0){
                //return Response.created(new URI("Added student")).build();
                return Response.created(new URI("http://localhost:8080/rest-api/students/"+Integer.toString(student
                        .getId())+"/"))
                        .build();
            }
            else
                return Response.status(Response.Status.CONFLICT).build();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }


    @PUT
    @Path("{id}")
    @Consumes("application/Json")
    public Response editStudent(@PathParam("id") int id, String json){
        Student student = this.studentManager.get(id);
        if(student==null)
            return Response.status(Response.Status.NOT_FOUND).build();
        ObjectMapper mapper = new ObjectMapper();
        Student newStudent = null;
        try {
            newStudent = mapper.readValue(json, Student.class);
            if(student.getId()!=newStudent.getId() && this.studentManager.get(newStudent.getId())!=null)
                return Response.status(Response.Status.CONFLICT).build();
            this.studentManager.removeStudent(student);
            if(this.studentManager.addStudent(newStudent)==0)
                return Response.created(new URI("http://localhost:8080/rest-api/students/"+Integer.toString(student
                    .getId())+"/"))
                    .build();
            else
                return Response.status(Response.Status.CONFLICT).build();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }

    @DELETE
    @Path("{id}")
    public Response deleteStudent(@PathParam("id") int id){
        Student student = this.studentManager.get(id);
        if(student==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.studentManager.removeStudent(student);
        return Response.ok().build();
    }

}
