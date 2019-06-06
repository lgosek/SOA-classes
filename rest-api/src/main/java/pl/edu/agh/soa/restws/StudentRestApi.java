package pl.edu.agh.soa.restws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.io.FileUtils;
import pl.edu.agh.soa.model.Student;
import pl.edu.agh.soa.model.StudentManager;
import pl.edu.agh.soa.model.proto.StudentProto;
import pl.edu.agh.soa.restauth.JWTTokenNeeded;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Base64;


@Path("/students")
@Produces("application/Json")
@Consumes("application/Json")
@Api(value = "StudentRESTService", description = "Simple REST Service for students management")
public class StudentRestApi{
    @Inject
    private StudentManager studentManager;

    private ObjectMapper mapper = new ObjectMapper();

    @GET
    @Path("{id}/firstname")
    @ApiOperation(value = "Get first name of Student with specific id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of data"),
            @ApiResponse(code = 404, message = "Student with given id not found")})
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

    @GET
    @Path("{id}/lastname")
    @ApiOperation(value = "Get last name of Student with specific id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of data"),
            @ApiResponse(code = 404, message = "Student with given id not found")})
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

    @GET
    @Path("{id}/number")
    @ApiOperation(value = "Get student number of Student with specific id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of data"),
            @ApiResponse(code = 404, message = "Student with given id not found")})
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

    @GET
    @Path("{id}/avatar")
    @ApiOperation(value = "Get encoded (Base64) avatar of Student with specific id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of data"),
            @ApiResponse(code = 404, message = "Student with given id not found")})
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
    @ApiOperation(value = "Get Student with specific id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of Student", response = Student.class),
            @ApiResponse(code = 404, message = "Student with given id not found")})
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
    @ApiOperation(value = "Get all Students")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of data", responseContainer = "List", response =
                    Student.class),
            @ApiResponse(code = 404, message = "No students found")})
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

    @GET
    @Path("/proto")
    @Produces("application/protobuf")
    @ApiOperation(value = "Get all Students in Protocol Buffers format")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of data"),
            @ApiResponse(code = 404, message = "No students found")})
    public Response getAllStudentsProto(){
        StudentProto.StudentList.Builder listBuilder = StudentProto.StudentList.newBuilder();
        for (Student s: studentManager.getStudents()) {
            StudentProto.Student.Builder studentBuilder = StudentProto.Student.newBuilder()
                    .setId(Integer.toString(s.getId()))
                    .setFirstName(s.getFirstName())
                    .setLastName(s.getLastName())
                    .setStudentNumber(Integer.toString(s.getStudentNumber()))
                    .setAvatarFilename(s.getAvatarFilename())
                    .addAllCourses(s.getCourses());

            listBuilder.addStudent(studentBuilder.build());
        }
        return Response.ok(listBuilder.build()).build();
    }

    @PUT
    @Path("{id}/firstname")
    @JWTTokenNeeded
    @ApiOperation(value = "Set first name of Student with specific id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Data changed successfully"),
            @ApiResponse(code = 400, message = "Invalid request body"),
            @ApiResponse(code = 401, message = "Authorization error (no JWT token or token expired)"),
            @ApiResponse(code = 404, message = "Student with given id not found")})
    public Response setStudentFirstName(@PathParam("id") int id, String json){
        try {
            ObjectNode node = mapper.readValue(json, ObjectNode.class);
            String newName = node.get("firstName").asText();
            this.studentManager.get(id).setFirstName(newName);
            return Response.ok().build();
        } catch (IOException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}/lastname")
    @JWTTokenNeeded
    @ApiOperation(value = "Set last name of Student with specific id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Data changed successfully"),
            @ApiResponse(code = 400, message = "Invalid request body"),
            @ApiResponse(code = 401, message = "Authorization error (no JWT token or token expired)"),
            @ApiResponse(code = 404, message = "Student with given id not found")})
    public Response setStudentLastName(@PathParam("id") int id, String json){
        try {
            ObjectNode node = mapper.readValue(json, ObjectNode.class);
            String newLastName = node.get("lastName").asText();
            this.studentManager.get(id).setLastName(newLastName);
            return Response.ok().build();
        } catch (IOException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}/number")
    @JWTTokenNeeded
    @ApiOperation(value = "Set student number of Student with specific id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Data changed successfully"),
            @ApiResponse(code = 400, message = "Invalid request body"),
            @ApiResponse(code = 401, message = "Authorization error (no JWT token or token expired)"),
            @ApiResponse(code = 404, message = "Student with given id not found")})
    public Response setStudentNumber(@PathParam("id") int id, String json){
        try {
            ObjectNode node = mapper.readValue(json, ObjectNode.class);
            int newNumber = node.get("number").asInt();
            this.studentManager.get(id).setStudentNumber(newNumber);
            return Response.ok().build();
        } catch (IOException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @JWTTokenNeeded
    @ApiOperation(value = "Edit properties of Student with specific id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Data changed successfully"),
            @ApiResponse(code = 400, message = "Invalid request body"),
            @ApiResponse(code = 401, message = "Authorization error (no JWT token or token expired)"),
            @ApiResponse(code = 404, message = "Student with given id not found"),
            @ApiResponse(code = 409, message = "Student with id given in request body already exists")})
    public Response editStudent(@PathParam("id") int id, @Valid Student newStudent){
        Student student = this.studentManager.get(id);
        if(student==null)
            return Response.status(Response.Status.NOT_FOUND).build();
        //ObjectMapper mapper = new ObjectMapper();
        try {
            if(student.getId()!=newStudent.getId() && this.studentManager.get(newStudent.getId())!=null)
                return Response.status(Response.Status.CONFLICT).build();

            student.setFirstName(newStudent.getFirstName());
            student.setLastName(newStudent.getLastName());
            student.setStudentNumber(newStudent.getStudentNumber());
            student.setAvatarFilename(newStudent.getAvatarFilename());
            student.setCourses(newStudent.getCourses());
            student.setId(newStudent.getId());

            return Response.ok().build();

//            this.studentManager.removeStudent(student);
//            if(this.studentManager.addStudent(newStudent)==0)
//                return Response.created(new URI("http://localhost:8080/rest-api/students/"+Integer.toString(student
//                    .getId())+"/"))
//                    .build();
//            else
//                return Response.status(Response.Status.CONFLICT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();

    }

    @POST
    @Path("/")
    @JWTTokenNeeded
    @ApiOperation(value = "Add new Student")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Student created successfully"),
            @ApiResponse(code = 400, message = "Invalid request body"),
            @ApiResponse(code = 401, message = "Authorization error (no JWT token or token expired)"),
            @ApiResponse(code = 404, message = "Student with given id not found")})
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

    @DELETE
    @Path("{id}")
    @JWTTokenNeeded
    @ApiOperation(value = "Delete Student with specific id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Student deleted successfully"),
            @ApiResponse(code = 401, message = "Authorization error (no JWT token or token expired)"),
            @ApiResponse(code = 404, message = "Student with given id not found")})
    public Response deleteStudent(@PathParam("id") int id){
        Student student = this.studentManager.get(id);
        if(student==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.studentManager.removeStudent(student);
        return Response.ok().build();
    }

}
