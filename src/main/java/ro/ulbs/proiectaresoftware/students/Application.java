package ro.ulbs.proiectaresoftware.students;

import java.util.ArrayList;
import java.util.List;



public class Application {

    public static boolean checkStudent(List<Student> list, Student student) {
        for(Student s : list){
            if(s.getNume().equals(student.getNume())
                    && s.getPrenume().equals(student.getPrenume())
                    && s.getFormatieDeStudiu().equals(student.getFormatieDeStudiu())
                    && s.getNumarMatricol() == student.getNumarMatricol())
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Student s1 = new Student(112, "Ioan", "Popa", "TI21/1");
        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1");
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI22/1");
        Student s5 = new Student(122, "Eugen", "Uritescu", "TI22/2");

        //STUDENT ARRAY
        //Student[] students = {s1, s2, s3, s4, s5};
        /*
        for(int i=0; i<5; i++) {
            System.out.println(students[i].toString());
        }
         */

        //STUDENT LIST
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.forEach(student -> System.out.println(student.toString()));

        Student alis = new Student(120, "Alis", "Popa", "TI21/2");

        System.out.println("Rezultatul cautarii: " + checkStudent(studentList,
                alis//new Student(120, "Alis", "Popa", "TI21/2")
                ));
        System.out.println("Rezultatul cautarii: " + checkStudent(studentList,
                new Student(112, "Maria", "Popa", "TI21/1")
                ));




    }
}



