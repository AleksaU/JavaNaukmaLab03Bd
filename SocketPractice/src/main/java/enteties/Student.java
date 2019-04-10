package enteties;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;

@JsonAutoDetect
public class Student {

    private int id;
    private String fio;
    private int course;

    @JsonDeserialize(keyUsing = DisciplinesDeserializer.class)
    private Map<Discipline, Integer> listOfStudentsDisciplinesAndMarks;

    public Student() {
    }

    public Student(Map<Discipline, Integer> listOfStudentsDisciplinesAndMarks) {
        this.listOfStudentsDisciplinesAndMarks = listOfStudentsDisciplinesAndMarks;
    }

    public Student(int id, String fio, int course, Map<Discipline, Integer> listOfStudentsDisciplinesAndMarks) {
        this.id = id;
        this.fio = fio;
        this.course = course;
        this.listOfStudentsDisciplinesAndMarks = listOfStudentsDisciplinesAndMarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Map<Discipline, Integer> getListOfStudentsDisciplinesAndMarks() {
        return listOfStudentsDisciplinesAndMarks;
    }

    public void setListOfStudentsDisciplinesAndMarks(Map<Discipline, Integer> listOfStudentsDisciplinesAndMarks) {
        this.listOfStudentsDisciplinesAndMarks = listOfStudentsDisciplinesAndMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", course=" + course +
                ", listOfStudentsDisciplinesAndMarks=" + listOfStudentsDisciplinesAndMarks +
                '}';
    }
}
