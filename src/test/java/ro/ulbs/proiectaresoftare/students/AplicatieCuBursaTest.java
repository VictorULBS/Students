package ro.ulbs.proiectaresoftare.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.ulbs.proiectaresoftware.students.AplicatieCuBursa;
import ro.ulbs.proiectaresoftware.students.Student;
import ro.ulbs.proiectaresoftware.students.StudentBursier;

import java.util.ArrayList;
import java.util.List;

public class AplicatieCuBursaTest {
    AplicatieCuBursa aplicatieCuBursa;

    @BeforeEach
    void setUp() {
        aplicatieCuBursa = new AplicatieCuBursa();
    }

    @Test
    public void sorteazaTest(){
        //arrange
        List<StudentBursier> list = new ArrayList<>();
        StudentBursier studentBursier0 = new StudentBursier(new Student(1025,"Andrei","Popa","ISM141/2"), 8.70, 725.50);
        StudentBursier studentBursier1 = new StudentBursier(new Student(1024,"Ioan","Mihalcea","ISM141/1"), 9.80, 801.10);
        StudentBursier studentBursier2 = new StudentBursier(new Student(1029,"Bianca","Popescu","TI131/1,"), 9.10, 780.80);
        StudentBursier studentBursier3 = new StudentBursier(new Student(1026,"Anamaria","Prodan","TI131/1"), 8.90, 745.50);
        StudentBursier studentBursier4 = new StudentBursier(new Student(1029,"Bianca","Popescu","TI131/1,"), 9.10, 100.00);

        list.add(studentBursier0);
        list.add(studentBursier1);
        list.add(studentBursier2);
        list.add(studentBursier3);
        list.add(studentBursier4);

        //act
        list = aplicatieCuBursa.sorteaza(list);

        //assert
        Assertions.assertEquals(list.get(0).getNume(), "Mihalcea");
        Assertions.assertEquals(list.get(1).getNume(), "Popa");
        Assertions.assertEquals(list.get(2).getNume(), "Prodan");
        Assertions.assertEquals(list.get(3), studentBursier3);
        Assertions.assertEquals(list.get(4), studentBursier4);
    }
}
