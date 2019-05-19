package pl.agh.edu.soa.connector;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-04-11T22:09:58.840+02:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://ws.soa.agh.edu.pl/", name = "StudentService")
@XmlSeeAlso({ObjectFactory.class})
public interface StudentService {

    @WebMethod
    @RequestWrapper(localName = "getStudentNumber", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.GetStudentNumber")
    @ResponseWrapper(localName = "getStudentNumberResponse", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.GetStudentNumberResponse")
    @WebResult(name = "StudentNumber", targetNamespace = "")
    public int getStudentNumber(
        @WebParam(name = "Id", targetNamespace = "")
        int id
    );

    @WebMethod
    @RequestWrapper(localName = "setStudentLastName", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.SetStudentLastName")
    @ResponseWrapper(localName = "setStudentLastNameResponse", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.SetStudentLastNameResponse")
    @WebResult(name = "status", targetNamespace = "")
    public java.lang.String setStudentLastName(
        @WebParam(name = "Id", targetNamespace = "")
        int id,
        @WebParam(name = "LastName", targetNamespace = "")
        java.lang.String lastName
    );

    @WebMethod
    @RequestWrapper(localName = "getStudentFirstName", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.GetStudentFirstName")
    @ResponseWrapper(localName = "getStudentFirstNameResponse", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.GetStudentFirstNameResponse")
    @WebResult(name = "FirstName", targetNamespace = "")
    public java.lang.String getStudentFirstName(
        @WebParam(name = "Id", targetNamespace = "")
        int id
    );

    @WebMethod
    @RequestWrapper(localName = "addStudent", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.AddStudent")
    @ResponseWrapper(localName = "addStudentResponse", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.AddStudentResponse")
    @WebResult(name = "status", targetNamespace = "")
    public java.lang.String addStudent(
        @WebParam(name = "Id", targetNamespace = "")
        int id,
        @WebParam(name = "FirstName", targetNamespace = "")
        java.lang.String firstName,
        @WebParam(name = "LastName", targetNamespace = "")
        java.lang.String lastName,
        @WebParam(name = "StudentNumber", targetNamespace = "")
        int studentNumber
    );

    @WebMethod
    @RequestWrapper(localName = "getCourses", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.GetCourses")
    @ResponseWrapper(localName = "getCoursesResponse", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.GetCoursesResponse")
    @WebResult(name = "Courses", targetNamespace = "")
    public pl.agh.edu.soa.connector.GetCoursesResponse.Courses getCourses(
        @WebParam(name = "Id", targetNamespace = "")
        int id
    );

    @WebMethod
    @RequestWrapper(localName = "addCourse", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.AddCourse")
    @ResponseWrapper(localName = "addCourseResponse", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.AddCourseResponse")
    @WebResult(name = "status", targetNamespace = "")
    public java.lang.String addCourse(
        @WebParam(name = "Id", targetNamespace = "")
        int id,
        @WebParam(name = "CourseName", targetNamespace = "")
        java.lang.String courseName
    );

    @WebMethod
    @RequestWrapper(localName = "getAvatar", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.GetAvatar")
    @ResponseWrapper(localName = "getAvatarResponse", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.GetAvatarResponse")
    @WebResult(name = "EncodedAvatar", targetNamespace = "")
    public java.lang.String getAvatar(
        @WebParam(name = "Id", targetNamespace = "")
        int id
    );

    @WebMethod
    @RequestWrapper(localName = "getAllStudents", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.GetAllStudents")
    @ResponseWrapper(localName = "getAllStudentsResponse", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.GetAllStudentsResponse")
    @WebResult(name = "StudentsList", targetNamespace = "")
    public pl.agh.edu.soa.connector.GetAllStudentsResponse.StudentsList getAllStudents();

    @WebMethod
    @RequestWrapper(localName = "getStudentLastName", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.GetStudentLastName")
    @ResponseWrapper(localName = "getStudentLastNameResponse", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.GetStudentLastNameResponse")
    @WebResult(name = "LastName", targetNamespace = "")
    public java.lang.String getStudentLastName(
        @WebParam(name = "Id", targetNamespace = "")
        int id
    );

    @WebMethod
    @RequestWrapper(localName = "setStudentNumber", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.SetStudentNumber")
    @ResponseWrapper(localName = "setStudentNumberResponse", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.SetStudentNumberResponse")
    @WebResult(name = "status", targetNamespace = "")
    public java.lang.String setStudentNumber(
        @WebParam(name = "Id", targetNamespace = "")
        int id,
        @WebParam(name = "Number", targetNamespace = "")
        int number
    );

    @WebMethod
    @RequestWrapper(localName = "removeCourse", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.RemoveCourse")
    @ResponseWrapper(localName = "removeCourseResponse", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.RemoveCourseResponse")
    @WebResult(name = "status", targetNamespace = "")
    public java.lang.String removeCourse(
        @WebParam(name = "Id", targetNamespace = "")
        int id,
        @WebParam(name = "CourseName", targetNamespace = "")
        java.lang.String courseName
    );

    @WebMethod
    @RequestWrapper(localName = "setStudentFirstName", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.SetStudentFirstName")
    @ResponseWrapper(localName = "setStudentFirstNameResponse", targetNamespace = "http://ws.soa.agh.edu.pl/", className = "pl.agh.edu.soa.connector.SetStudentFirstNameResponse")
    @WebResult(name = "status", targetNamespace = "")
    public java.lang.String setStudentFirstName(
        @WebParam(name = "Id", targetNamespace = "")
        int id,
        @WebParam(name = "FirstName", targetNamespace = "")
        java.lang.String firstName
    );
}
