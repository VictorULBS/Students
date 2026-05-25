package ro.ulbs.proiectaresoftware.students.strategy;

import ro.ulbs.proiectaresoftware.students.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StudentiInFisier implements StrategieOutput {
    public void outputStudenti(List<Student> studenti) {
        String filename = "strategy_out.txt";
        Path path = Paths.get(filename);
        studenti.forEach(student -> {
           String new_text = student.toString();
           try{
               Files.write(path, new_text.getBytes());
           }
           catch(IOException e){
               e.printStackTrace();
           }
        });

    }


}
