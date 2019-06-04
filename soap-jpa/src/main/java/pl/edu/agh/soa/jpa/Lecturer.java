package pl.edu.agh.soa.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
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

    @OneToMany(
            mappedBy = "lecturer",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Course> courses = new HashSet<>();

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

    @JsonIgnore
    public Set<Course> getCourses () {
        return courses;
    }

    public void setCourses (Set<Course> courses) {
        this.courses = courses;
    }

    public void addCourse (Course course){
        this.courses.add(course);
    }
}
