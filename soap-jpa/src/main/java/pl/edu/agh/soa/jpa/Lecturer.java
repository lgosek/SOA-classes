package pl.edu.agh.soa.jpa;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Lecturers")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecturerId")
    private Integer id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "courseID")
    private Set<Course> courses;

    public Lecturer () {
    }

    public Integer getId () {
        return id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public Set<Course> getCourses () {
        return courses;
    }

    public void setCourses (Set<Course> courses) {
        this.courses = courses;
    }
}
