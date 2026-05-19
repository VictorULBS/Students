package ro.ulbs.proiectaresoftware.students;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements StrategieInput {
    public List<Student> inputStudenti() {
        String filename = "strategy_in.txt";
        List<Student> studenti = new ArrayList<Student>();
        Path path = Paths.get(filename);

        try{
            Files.lines(path).forEach(line -> {
                String[] tokens = line.split(",");
                int NumarMatricol = Integer.parseInt(tokens[0]);
                Student s = new Student(NumarMatricol, tokens[1], tokens[2], tokens[3]);
                studenti.add(s);
            });
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return studenti;
    }
}
