package pl.edu.agh.soa.jpa;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Students")
public class StudentJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(
            name = "StudentCourses",
            joinColumns = @JoinColumn(name = "studentId", referencedColumnName = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "courseId", referencedColumnName = "courseId"))
    private Set<Course> courses = new HashSet<>();

    @JoinColumn(name = "studentInfoId", unique = true)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private StudentInfo studentInfo;

    public StudentJPA () {
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

    public void addCourse (Course course){
        this.courses.add(course);
    }
}
