package storage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import enteties.Discipline;
import enteties.builders.DisciplinesBuilder;
import enteties.Student;
import enteties.builders.StudentBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {

    public void createBaseDataToFile(File file) throws IOException {
        Discipline java = new DisciplinesBuilder().setId(1)
                .setName("Java Core").setCredits(4).createDisciplines();
        Discipline haskell = new DisciplinesBuilder().setId(2)
                .setName("Haskell").setCredits(3.5).createDisciplines();
        Discipline databases = new DisciplinesBuilder().setId(3)
                .setName("Databases").setCredits(4).createDisciplines();

        Map<Discipline, Integer> firstStudentsMarks = new HashMap<>();
        firstStudentsMarks.put(java, 100);
        firstStudentsMarks.put(haskell, 96);
        firstStudentsMarks.put(databases, 94);

        Student firstStudent = new StudentBuilder().setId(1).setFio("Olha Yurieva")
                .setCourse(3).setListOfStudentsDisciplinesAndMarks(firstStudentsMarks).createStudent();

        Map<Discipline, Integer> secondStudentsMarks = new HashMap<>();
        secondStudentsMarks.put(java, 91);
        secondStudentsMarks.put(haskell, 96);
        secondStudentsMarks.put(databases, 100);

        Student secondStudent = new StudentBuilder().setId(2).setFio("Vitaliy Chumak")
                .setCourse(3).setListOfStudentsDisciplinesAndMarks(secondStudentsMarks).createStudent();

        ObjectMapper mapper = new ObjectMapper();

        SequenceWriter seqWriter = mapper.writer().writeValuesAsArray(file);
        seqWriter.write(firstStudent);
        seqWriter.write(secondStudent);
        seqWriter.close();
    }

    public List<Student> readFromJson(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Student> myObjects = mapper.readValue(file, new TypeReference<List<Student>>(){});

        return myObjects;
    }
}
