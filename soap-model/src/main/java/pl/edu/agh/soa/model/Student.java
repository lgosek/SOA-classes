package pl.edu.agh.soa.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    private int Id;

    @NotNull
    private String FirstName;
    @NotNull
    private String LastName;

    @Min(value = 100000, message = "Student number must be greater or equal than 100000")
    @Max(value = 999999, message = "Student number must be smaller or equal than 999999")
    private int StudentNumber;

    private List<String> Courses;
    private String AvatarFilename;

    public Student(int id, String name, String lastName, int num){
        this.Id = id;
        this.FirstName = name;
        this.LastName = lastName;
        this.StudentNumber = num;
        this.Courses = new LinkedList<>();
        this.Courses.add("Kurs1");
        this.Courses.add("Kurs2");
        this.AvatarFilename = "/home/lukasz/Dokumenty/SOA/backup/soap/soap-api/src/main/resources/img.jpg";
    }

    public Student(){
        this(0, "Adam","Nowak",111111);
    }

    public void setId (int id) {
        this.Id = id;
    }

    public void setCourses (List<String> courses) {
        this.Courses = courses;
    }

    public void setAvatarFilename (String avatarFilename) {
        this.AvatarFilename = avatarFilename;
    }

    public void setFirstName (String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName (String LastName) {
        this.LastName = LastName;
    }

    public void setStudentNumber (int StudentNumber) {
        this.StudentNumber = StudentNumber;
    }

    public void addCourse (String courseName){
        if (!this.Courses.contains(courseName))
            this.Courses.add(courseName);
    }

    public int deleteCourse (String courseName){
        if (this.Courses.contains(courseName)) {
            this.Courses.remove(courseName);
            return 0;
        }
        return -1;
    }

    @XmlElement(name = "id")
    public int getId () {
        return Id;
    }

    @XmlElement(name = "firstName")
    public String getFirstName () {
        return FirstName;
    }

    @XmlElement(name = "lastName")
    public String getLastName () {
        return LastName;
    }

    @XmlElement(name = "studentNumber")
    public int getStudentNumber () {
        return StudentNumber;
    }

    @XmlElementWrapper(name = "courses")
    @XmlElement(name = "courseName")
    public List<String> getCourses () {
        return Courses;
    }

    @XmlElement(name = "avatarFilename")
    public String getAvatarFilename () {
        return AvatarFilename;
    }
}
