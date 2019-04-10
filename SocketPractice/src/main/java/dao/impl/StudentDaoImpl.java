package dao.impl;

import dao.StudentDao;
import enteties.Discipline;
import enteties.Student;
import storage.Storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements StudentDao {

    Storage storage = new Storage();
    List<Student> studentList = new ArrayList<>();

    public StudentDaoImpl(File file) throws IOException {
        studentList.addAll(storage.readFromJson(file));
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public Student getStudentById(int id) {
        return studentList.stream().filter(st -> st.getId() == id).findFirst().get();
    }

    public Map<Discipline, Integer> getStudentMarksForSubjectsById(int id) {
        for (Student st : studentList) {
            if(st.getId() == id) {
                return st.getListOfStudentsDisciplinesAndMarks();
            }
        }
        return (Map<Discipline, Integer>) Collections.EMPTY_MAP;
    }
}
