package ro.ulbs.proiectaresoftware.students;

import java.util.List;

public class StudentiInConsola implements StrategieOutput {
    public void outputStudenti(List<Student> studenti) {
        studenti.forEach(student -> {System.out.println(student);});
    }
}
