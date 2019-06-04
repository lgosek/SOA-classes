package pl.edu.agh.soa.restws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import pl.edu.agh.soa.jpa.Course;
import pl.edu.agh.soa.jpa.Lecturer;
import pl.edu.agh.soa.jpa.StudentInfo;
import pl.edu.agh.soa.jpa.StudentJPA;
import pl.edu.agh.soa.model.Student;
import pl.edu.agh.soa.restauth.JWTTokenNeeded;

import javax.annotation.Resource;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;


@Path("/jpa/students/")
@Produces("application/Json")
@Consumes("application/Json")
@Api(value = "Student REST Service using JPA", description = "Simple REST Service for students management")
public class RestApiJpa {
    @PersistenceContext(unitName = "soads") //wstrzyknięcie po nazwie z persistence.xml
    protected EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    private ObjectMapper mapper = new ObjectMapper();

    @GET
    @Path("/")
    @ApiOperation(value = "Get all Students")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of data", responseContainer = "List", response =
                    StudentJPA.class),
            @ApiResponse(code = 404, message = "No students found")})
    public Response getAllStudents(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentJPA> cq = cb.createQuery(StudentJPA.class);
        Root<StudentJPA> s = cq.from(StudentJPA.class);
        cq.select(s);
        TypedQuery<StudentJPA> query = entityManager.createQuery(cq);
        List<StudentJPA> students = query.getResultList();

        String returnJson;
        try {
            returnJson = mapper.writeValueAsString(students);
            return Response.ok(returnJson).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("{id}")
    @ApiOperation(value = "Get Student with specific id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of Student", response = StudentJPA.class),
            @ApiResponse(code = 404, message = "Student with given id not found")})
    public Response getStudent(@PathParam("id") Integer id){
        String returnJson;
        try {
            StudentJPA student = entityManager.find(StudentJPA.class, id);
            if(student==null)
                return Response.status(Response.Status.NOT_FOUND).build();
            returnJson = mapper.writeValueAsString(student);
            return Response.ok(returnJson).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("/")
//    @JWTTokenNeeded
    @ApiOperation(value = "Add new Student")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Student created successfully"),
            @ApiResponse(code = 400, message = "Invalid request body"),
            @ApiResponse(code = 401, message = "Authorization error (no JWT token or token expired)"),
            @ApiResponse(code = 409, message = "Student with given id exists")})
    public Response addStudent(StudentJPA student){
        if(student.getId() != null && entityManager.find(StudentJPA.class, student.getId()) != null)
            return Response.status(Response.Status.CONFLICT).build();
        try {
            userTransaction.begin();
            Session session = entityManager.unwrap(Session.class);
            Integer id = (Integer) session.save(student);
            entityManager.flush();
            userTransaction.commit();

            return Response.created(new URI("http://localhost:8080/rest-api/jpa/students/"+Integer.toString(id)+"/"))
                    .build();
        } catch (ConstraintViolationException e){
            return Response.status(Response.Status.CONFLICT).build();
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }















    private void createStudent () {
        StudentJPA student = new StudentJPA();
//        student.setId(new Integer(1));
        StudentInfo info = new StudentInfo();
        info.setFirstName("Jan");
        info.setLastName("Nowak");
        info.setGender("male");
//                entityManager.find(StudentInfo.class, 1);
//        info.setId(new Integer(1));
        student.setStudentInfo(info);

        Course course = new Course();
        course.setCourseName("SOA");

        Lecturer lecturer = new Lecturer();
        lecturer.setFirstName("Konrad");
        lecturer.setLastName("Slowacki");
        lecturer.addCourse(course);

        course.setLecturer(lecturer);

        student.addCourse(course);

//        entityManager.persist(student);
//        entityManager.persist(course);
//        entityManager.persist(lecturer);



//        try {
//            userTransaction.begin();

//            entityManager.merge(student);
//            userTransaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}
