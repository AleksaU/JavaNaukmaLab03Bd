package dao;

import enteties.Discipline;
import enteties.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    List<Student> getAllStudents();
    Student getStudentById(int id);
    Map<Discipline, Integer> getStudentMarksForSubjectsById(int id);
}
