package pl.edu.agh.soa.model;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.LinkedList;
import java.util.List;

@Singleton
public class StudentManager {
    private List<Student> students;

    public StudentManager() {

    }

    @PostConstruct
    void init(){
        this.students = new LinkedList<>();
        students.add(new Student());
        students.add(new Student(1, "Karol", "Kowalski", 123456));
        students.add(new Student(2, "Michał", "Pedziwiatr", 654321));
    }

    public int addStudent(int id, String name, String lastName, int num){
        if (this.get(id) == null) {
            this.students.add(new Student(id, name, lastName, num));
            return 0;
        }
        return -1;
    }

    public int addStudent(Student student){
        if (this.get(student.getId()) == null) {
            this.students.add(student);
            return 0;
        }
        return -1;
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }

    public List<Student> getStudents () {
        return this.students;
    }

    public Student get(int id){
        for (Student s: this.students) {
            if(s.getId()==id)
                return s;
        }
        return null;
    }
}
