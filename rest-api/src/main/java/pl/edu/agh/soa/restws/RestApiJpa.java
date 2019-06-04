package pl.edu.agh.soa.restws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.io.FileUtils;
import pl.edu.agh.soa.jpa.Student;
import pl.edu.agh.soa.jpa.StudentInfo;
import pl.edu.agh.soa.restauth.JWTTokenNeeded;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Base64;


@Path("/jpa/students/")
@Produces("application/Json")
@Consumes("application/Json")
@Api(value = "StudentRESTService", description = "Simple REST Service for students management")
public class RestApiJpa {
    @PersistenceContext(unitName = "soads") //wstrzyknięcie po nazwie z persistence.xml
    protected EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    private ObjectMapper mapper = new ObjectMapper();

    @GET
    @Path("{id}")
    @ApiOperation(value = "Get Student with specific id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of Student", response = Student.class),
            @ApiResponse(code = 404, message = "Student with given id not found")})
    public Response getStudent(@PathParam("id") int id){
//        createStudent();
        String returnJson;
        try {
            StudentInfo student = entityManager.find(StudentInfo.class, 1);
            returnJson = mapper.writeValueAsString(student);
            return Response.ok(returnJson).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
//        return Response.ok().build();
    }

    @Transactional
    private void createStudent () {
//        student.setId(new Integer(1));
        StudentInfo info = new StudentInfo();
//        info.setId(new Integer(1));
        info.setFirstName("Jan");
        info.setLastName("Nowak");
        info.setGender("male");

        try {
            userTransaction.begin();
            entityManager.persist(info);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
