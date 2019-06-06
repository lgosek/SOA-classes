package pl.edu.agh.soa.jpa;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseId")
    private Integer id;

    @Column(name = "courseName")
    private String courseName;

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "lecturerId")
    private Lecturer lecturer;

    public Course () {
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getCourseName () {
        return courseName;
    }

    public void setCourseName (String courseName) {
        this.courseName = courseName;
    }

    public Lecturer getLecturer () {
        return lecturer;
    }

    public void setLecturer (Lecturer lecturer) {
        this.lecturer = lecturer;
    }
}
