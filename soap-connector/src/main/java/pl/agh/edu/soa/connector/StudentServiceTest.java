package pl.agh.edu.soa.connector;


import org.apache.commons.io.FileUtils;

import javax.xml.ws.BindingProvider;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class StudentServiceTest {
    private static void setCred(StudentService service, String username, String password){
        BindingProvider provider = (BindingProvider) service;
        provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, username);
        provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,password);
    }

    public static void main (String[] args) {
        StudentServiceService studentService = new StudentServiceService();
        StudentService service = studentService.getStudentServicePort();

        //ustawienie autoryzacji user2
        setCred(service, "user2", "password");
        //System.out.println(service.getStudentNumber());

        //dodanie kursów do listy
        service.addCourse(0,"SOA");
        service.addCourse(0,"PSI");
        service.addCourse(0,"Kompilatory");

        //pobranie listy kursów
        GetCoursesResponse.Courses courses = service.getCourses(0);

        List<String> coursesList = courses.getCourseName();
        System.out.println(coursesList.toString());

        //ustawienie autoryzacji user1 i ustawienie StudentNumber
        setCred(service, "user1", "password");
        service.setStudentNumber(0,289724);

        setCred(service, "user2", "password");
        System.out.println(service.getStudentNumber(0));

        String encodedAvatar = service.getAvatar(0);

        byte[] fileContent = Base64.getDecoder().decode(encodedAvatar);
        try {
            FileUtils.writeByteArrayToFile(new File
                    ("/home/lukasz/Dokumenty/SOA/soap/soap-connector/src/main/resources/avatar.jpg"), fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //pobranie wszystkich studentów
        GetAllStudentsResponse.StudentsList students = service.getAllStudents();
        List<Student> studentsList = students.getStudent();

        for (Student s: studentsList) {
            System.out.println(s.firstName + " " + s.lastName);
        }
    }
}
