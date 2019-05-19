package pl.edu.agh.soa.ws;

import org.apache.commons.io.FileUtils;
import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;
import pl.edu.agh.soa.model.Student;
import pl.edu.agh.soa.model.StudentManager;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Stateless
@WebService
@SecurityDomain("studentDomain")
@DeclareRoles({"studentAdmin", "studentUser", ""})
@WebContext(authMethod="BASIC",transportGuarantee="NONE")
public class StudentService {
    @Inject
    private StudentManager studentManager;

    @WebMethod(operationName = "setStudentFirstName")
    @WebResult(name = "status")
    @PermitAll
    public String setStudentFirstName(@WebParam(name = "Id") int id, @WebParam(name = "FirstName") String firstName){
        this.studentManager.get(id).setFirstName(firstName);
        return "OK";
    }

    @WebMethod(operationName = "setStudentLastName")
    @WebResult(name = "status")
    @PermitAll
    public String setStudentLastName(@WebParam(name = "Id") int id, @WebParam(name = "LastName") String LastName){
        this.studentManager.get(id).setLastName(LastName);
        return "OK";
    }

    @WebMethod(operationName = "setStudentNumber")
    @RolesAllowed("studentAdmin")
    @WebResult(name = "status")
    public String setStudentNumber(@WebParam(name = "Id") int id, @WebParam(name = "Number") int num){
        this.studentManager.get(id).setStudentNumber(num);
        return "OK";
    }

    @WebMethod(operationName = "addCourse")
    @WebResult(name = "status")
    @PermitAll
    public String addCourse(@WebParam(name = "Id") int id, @WebParam(name = "CourseName") String coursename){
        this.studentManager.get(id).addCourse(coursename);
        return "OK";
    }

    @WebMethod(operationName = "removeCourse")
    @WebResult(name = "status")
    @PermitAll
    public String removeCourse(@WebParam(name = "Id") int id, @WebParam(name = "CourseName") String coursename){
        int ret = this.studentManager.get(id).deleteCourse(coursename);
        if (ret == 0)
            return "Deleted";
        else
            return "No such course";
    }

    @WebMethod(operationName = "addStudent")
    @WebResult(name = "status")
    @PermitAll
    public String addStudent(@WebParam(name = "Id") int id, @WebParam(name = "FirstName") String name, @WebParam(name
            = "LastName") String lastName, @WebParam(name = "StudentNumber") int num){
        int ret = this.studentManager.addStudent(id, name, lastName, num);
        if(ret==0)
            return "OK";
        else
            return "Student with that ID already exists!";
    }


    //-----------------------------

    @PermitAll
    @WebMethod(operationName = "getStudentFirstName")
    @WebResult(name = "FirstName")
    public String getStudentFirstName(@WebParam(name = "Id") int id){
        return this.studentManager.get(id).getFirstName();
    }

    @WebMethod(operationName = "getStudentLastName")
    @WebResult(name = "LastName")
    @PermitAll
    public String getStudentLastName(@WebParam(name = "Id") int id){
        return this.studentManager.get(id).getLastName();
    }

    @WebMethod(operationName = "getStudentNumber")
    @PermitAll
    @WebResult(name = "StudentNumber")
    public int getStudentNumber(@WebParam(name = "Id") int id){
        return this.studentManager.get(id).getStudentNumber();
    }

    @WebMethod(operationName = "getCourses")
    @WebResult(name = "courses")
    @XmlElementWrapper(name = "Courses")
    @XmlElement(name = "CourseName")
    @PermitAll
    public List<String> getCoursesList(@WebParam(name = "Id") int id){
        return this.studentManager.get(id).getCourses();
    }

    @WebMethod(operationName = "getAvatar")
    @WebResult(name = "EncodedAvatar")
    @PermitAll
    public String getAvatar(@WebParam(name = "Id") int id) {
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(new File(studentManager.get(id).getAvatarFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }

    @WebMethod(operationName = "getAllStudents")
    @WebResult(name = "students")
    @XmlElementWrapper(name = "StudentsList")
    @XmlElement(name = "Student")
    @PermitAll
    public List<Student> getAllStudents(){
        return this.studentManager.getStudents();
    }

}
