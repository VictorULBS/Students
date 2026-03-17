package ro.ulbs.proiectaresoftware.students;

public class Application {
    public static void main(String[] args) {

        Student s1 = new Student(112, "Ioan", "Popa", "TI21/1");
        Student s2 = new Student(112, "Maria", "Oprea", "TI21/1");
        Student s3 = new Student(120, "Alis", "Popa", "TI21/2");
        Student s4 = new Student(122, "Mihai", "Vecerdea", "TI22/1");
        Student s5 = new Student(122, "Eugen", "Uritescu", "TI22/2");
        Student[] students = {s1, s2, s3, s4, s5};
        String header = String.format("%10s %10s %10s %10s", "numarMatricol", "Nume", "Prenume", "formatieDeStudiu");
        System.out.println(header);
        for(int i=0; i<5; i++) {
            System.out.println(students[i].toString());
        }
        String s = "numarMatricol";
    }
}
