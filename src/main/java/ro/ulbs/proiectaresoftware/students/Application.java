package ro.ulbs.proiectaresoftware.students;
/*
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
*/

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


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

    public static void exercitiuHashMap(){
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
    }

    public static void exercitiuBursieri(){
        ArrayList<StudentBursier> bursieri = new ArrayList<>();
        bursieri.add( new StudentBursier(new Student(1025,"Andrei","Popa","ISM141/2"), 8.70, 725.50));
        bursieri.add( new StudentBursier(new Student(1024,"Ioan","Mihalcea","ISM141/1"), 9.80, 801.10));
        bursieri.add( new StudentBursier(new Student(1026,"Anamaria","Prodan","TI131/1"), 8.90, 745.50));
        bursieri.add( new StudentBursier(new Student(1029,"Bianca","Popescu","TI131/1,"), 9.10, 780.80));

        Path path = Paths.get("bursieri_out.txt");
        bursieri.forEach(student -> {
            String new_text = student.toString();
            try{
                Files.write(path, new_text.getBytes(), StandardOpenOption.APPEND);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        });
    }

    public static void exercitiuImutabilitate(List<Student> totalList){
        List<Student> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        for(int i = 0; i < totalList.size(); i++){
            Student s;
            if(i<totalList.size()/2) { s = mutaStudent(totalList.get(i), "TI23/1"); list1.add(s);}
            else { s = mutaStudent(totalList.get(i), "TI23/2"); list2.add(s);}
        }
        list1.forEach(student -> System.out.println(student.toString()));
        list2.forEach(student -> System.out.println(student.toString()));

    }

    public static Student mutaStudent(Student s, String formatieNoua){
        return new Student(s.getNumarMatricol(), s.getPrenume(), s.getNume(), formatieNoua);
    }

    /*
    public static void exercitiuExcel(List<Student> studentList){
        try{
            OutputStream fileOut = new FileOutputStream("laboratoe8_students.xls");
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("laboratoe8_students");
            int i = 0;
            for(Student student : studentList){
                Row row = sheet.createRow(i++);
                row.createCell(0).setCellValue(student.getNumarMatricol());
                row.createCell(1).setCellValue(student.getPrenume());
                row.createCell(2).setCellValue(student.getNume());
                row.createCell(3).setCellValue(student.getFormatieDeStudiu());
            }
            wb.write(fileOut);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static List<Student> exercitiuCitireExcel (String file){
        try{
            InputStream fileIn = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        XSSFWorkbook wb = null;
        try{
            wb = new XSSFWorkbook(file);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }

        XSSFSheet sheet = wb.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();

        List<Student> studentList = new ArrayList<>();
        while(rowIterator.hasNext()){
            int numarMatricol = 0;
            String nume = null;
            String prenume = null;
            String formatie = null;

            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                switch(cell.getColumnIndex()){
                    case 0:
                        numarMatricol = (int) cell.getNumericCellValue();
                        break;
                    case 1:
                        nume = cell.getStringCellValue();
                        break;
                    case 2:
                        prenume = cell.getStringCellValue();
                        break;
                    case 3:
                        formatie = cell.getStringCellValue();
                        break;
                }
            }
            Student s = new Student(numarMatricol, prenume, nume, formatie);
            studentList.add(s);
        }
        return studentList;
    }
    */

    public static void exercitiuLambda(){
        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025,"Andrei","Popa","ISM141/2", 8.70),
                new Student(1024,"Ioan","Mihalcea","ISM141/1", 10.0),
                new Student(1026,"Anamaria","Prodan","TI131/1", 8.90),
                new Student(1029,"Bianca","Popescu","TI131/1,", 10.0),
                new Student(1029,"Maria","Pana","TI131/2,", 4.10),
                new Student(1029,"Gabriela","Mohanu","TI131/2,", 7.33),
                new Student(1029,"Marius","Nasta","TI131/2,", 3.20),
                new Student(1029,"Marius","Nasta","TI131/1,", 5.12),
                new Student(1029,"Andrei","Dobrescu","TI131/2,", 2.22)
        );

        System.out.println("Studenti cu nota 10: ");
        studentiCuNote.stream()
                .filter(student -> student.getNota() == 10)
                .forEach(student -> System.out.println(student.toString())
        );
        System.out.println("Studenti cu nota >5: ");
        studentiCuNote.stream()
                .filter(student -> student.getNota() >= 5)
                .forEach(student -> System.out.println(student.toString())
        );
        System.out.println();

        studentiCuNote.stream().map(
                student -> {
                    if(student.getNota() < 4d) student.setNota(4d);
                    return student;
                }
        ).forEach(System.out::println);


        Optional<Double> sum = studentiCuNote.stream()
                .map(student -> student.getNota())
                .reduce((nota1, nota2 ) -> nota1 + nota2);

        System.out.println("Suma notelor: " + sum.get());
        System.out.println("Media: " + sum.get() / studentiCuNote.size());
    }

    public static void main(String[] args) {

        Student s1 = new Student(112, "Ioan", "Popa", "TI21/1");
        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1");
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI22/1");
        Student s5 = new Student(122, "Eugen", "Uritescu", "TI22/2");
        Student s6 = new Student(122, "Anamaria", "Dragoi", "TI22/1");

        //STUDENT LIST
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);

        exercitiuLambda();

    }
}



