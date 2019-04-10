package enteties.builders;

import enteties.Discipline;
import enteties.Student;

import java.util.Map;

public class StudentBuilder {
    private int id;
    private String fio;
    private int course;
    private Map<Discipline, Integer> listOfStudentsDisciplinesAndMarks;

    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public StudentBuilder setFio(String fio) {
        this.fio = fio;
        return this;
    }

    public StudentBuilder setCourse(int course) {
        this.course = course;
        return this;
    }

    public StudentBuilder setListOfStudentsDisciplinesAndMarks(Map<Discipline, Integer> listOfStudentsDisciplinesAndMarks) {
        this.listOfStudentsDisciplinesAndMarks = listOfStudentsDisciplinesAndMarks;
        return this;
    }

    public Student createStudent() {
        return new Student(id, fio, course, listOfStudentsDisciplinesAndMarks);
    }
}