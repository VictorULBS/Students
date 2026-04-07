package ro.ulbs.proiectaresoftware.students;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Application {

    public static void updateStudentGrades(String fileName) throws IOException {}

    public static ArrayList<Student> readStudents(String fileName) throws IOException {
        ArrayList<Student> students = new ArrayList<>();
        Path path = Paths.get("students_in.txt");

        Files.lines(path).forEach(line -> {
            System.out.println(line);
            String[] tokens = line.split(",");
            int NumarMatricol = Integer.parseInt(tokens[0]);
            Student s = new Student(NumarMatricol, tokens[1], tokens[2], tokens[3]);
            s.setNota(0d);
            students.add(s);
        });

        return students;
    };

    public static void writeStudents(ArrayList<Student> students, String fileName) throws IOException {

        Path path = Paths.get(fileName);
        students.forEach(student -> {
            String new_text = student.toString();
            try {
                Files.write(path, new_text.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static boolean checkStudent(List<Student> list, Student student) {
        for(Student s : list){
            if(s.getNume().equals(student.getNume())
                    && s.getPrenume().equals(student.getPrenume())
                    && s.getFormatieDeStudiu().equals(student.getFormatieDeStudiu())
                    && s.getNumarMatricol() == student.getNumarMatricol()
                    && s.getNota() == student.getNota())
            {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Student> exercitiuCitireFisier(){
        ArrayList<Student> in_out_list;
        try{
            in_out_list = readStudents("students.txt");
            Comparator<Student> studentNameComparator = new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return s1.getNume().compareTo(s2.getNume());
                }
            };

            Collections.sort(in_out_list, studentNameComparator);
            //System.out.println("Rezultatul sortarii: " + in_out_list);
            //writeStudents(in_out_list, "students_out.txt");
            return in_out_list;
        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }

    }

    public static void exercitiuCautareLista(List<Student> studentList){
        Student alis = new Student(120, "Alis", "Popa", "TI21/2");
        alis.setNota(10d);

        System.out.println("Rezultatul cautarii: " + checkStudent(studentList,
                alis//new Student(120, "Alis", "Popa", "TI21/2")
        ));
        System.out.println("Rezultatul cautarii: " + checkStudent(studentList,
                new Student(112, "Maria", "Popa", "TI21/1")
        ));
    }

    public static void main(String[] args) {

        Student s1 = new Student(112, "Ioan", "Popa", "TI21/1");
        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1");
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI22/1");
        Student s5 = new Student(122, "Eugen", "Uritescu", "TI22/2");

        //STUDENT LIST
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.forEach(student -> student.setNota(0d));
        //studentList.forEach(student -> System.out.println(student.toString()));

        ArrayList<Student> listFromFile = exercitiuCitireFisier();
        HashMap<Integer, Student> studentHashMap = new HashMap<>();
        for(Student s : listFromFile){
            studentHashMap.put(s.getNumarMatricol(), s);
        }

        try{
            Path path = Paths.get("note_anon.txt");
            Files.lines(path).forEach( line -> {
               String[] tokens = line.split(",");
               String token0 = tokens[0];
               String token1 = tokens[1];
               Integer numarMatricol = Integer.parseInt(token0);
               Double nota = Double.parseDouble(token1);
               studentHashMap.get(numarMatricol).setNota(nota);
            });


        }
        catch(IOException e){
            e.printStackTrace();
        }

        studentHashMap.forEach( (numarMatricol, student) -> {System.out.println(studentHashMap.get(numarMatricol).toString());});
        //

        ArrayList<StudentBursier> bursieri = new ArrayList<>();
        bursieri.add( new StudentBursier(new Student(1025,"Andrei","Popa","ISM141/2"), 8.70, 725.50));
        bursieri.add( new StudentBursier(new Student(1024,"Ioan","Mihalcea","ISM141/1"), 9.80, 801.10));
        bursieri.add( new StudentBursier(new Student(1026,"Anamaria","Prodan","TI131/1"), 8.90, 745.50));
        bursieri.add( new StudentBursier(new Student(1029,"Bianca","Popescu","TI131/1,"), 9.10, 780.80));

        Path path = Paths.get("bursieri_out.txt");
        bursieri.forEach(student -> {
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



