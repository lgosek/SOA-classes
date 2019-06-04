package pl.edu.agh.soa.jpa;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "StudentCourses",
            joinColumns = @JoinColumn(name = "studentId", referencedColumnName = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "courseId", referencedColumnName = "courseId"))
    private Set<Course> courses = new HashSet<>();

    @JoinColumn(name = "studentInfoId", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private StudentInfo studentInfo;

    public Student () {
    }

    public Integer getId () {

        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public Set<Course> getCourses () {
        return courses;
    }

    public void setCourses (Set<Course> courses) {
        this.courses = courses;
    }

    public StudentInfo getStudentInfo () {
        return studentInfo;
    }

    public void setStudentInfo (StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }
}
