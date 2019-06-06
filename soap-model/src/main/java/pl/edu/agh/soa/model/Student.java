package pl.edu.agh.soa.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.LinkedList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    @NotNull
    private int id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @Min(value = 100000, message = "Student number must be greater or equal than 100000")
    @Max(value = 999999, message = "Student number must be smaller or equal than 999999")
    private int studentNumber;

    private List<String> courses;
    private String avatarFilename;

    public Student(int id, String name, String lastName, int num){
        this.id = id;
        this.firstName = name;
        this.lastName = lastName;
        this.studentNumber = num;
        this.courses = new LinkedList<>();
        this.courses.add("Kurs1");
        this.courses.add("Kurs2");
        this.avatarFilename = "/home/lukasz/Dokumenty/SOA/backup/soap/rest-api/src/main/resources/img.png";
    }

    public Student(){
        this(0, "Adam","Nowak",111111);
    }

    public void setId (int id) {
        this.id = id;
    }

    public void setCourses (List<String> courses) {
        this.courses = courses;
    }

    public void setAvatarFilename (String avatarFilename) {
        this.avatarFilename = avatarFilename;
    }

    public void setFirstName (String FirstName) {
        this.firstName = FirstName;
    }

    public void setLastName (String LastName) {
        this.lastName = LastName;
    }

    public void setStudentNumber (int StudentNumber) {
        this.studentNumber = StudentNumber;
    }

    public void addCourse (String courseName){
        if (!this.courses.contains(courseName))
            this.courses.add(courseName);
    }

    public int deleteCourse (String courseName){
        if (this.courses.contains(courseName)) {
            this.courses.remove(courseName);
            return 0;
        }
        return -1;
    }

    @XmlElement(name = "id")
    public int getId () {
        return id;
    }

    @XmlElement(name = "firstName")
    public String getFirstName () {
        return firstName;
    }

    @XmlElement(name = "lastName")
    public String getLastName () {
        return lastName;
    }

    @XmlElement(name = "studentNumber")
    public int getStudentNumber () {
        return studentNumber;
    }

    @XmlElementWrapper(name = "courses")
//    @XmlElement(name = "courseName")
    public List<String> getCourses () {
        return courses;
    }

    @XmlElement(name = "avatarFilename")
    public String getAvatarFilename () {
        return avatarFilename;
    }
}
