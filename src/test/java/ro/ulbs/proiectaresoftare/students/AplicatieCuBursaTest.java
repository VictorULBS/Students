package ro.ulbs.proiectaresoftare.students;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.ulbs.proiectaresoftware.students.AplicatieCuBursa;
import ro.ulbs.proiectaresoftware.students.StudentBursier;

import java.util.List;

public class AplicatieCuBursaTest {
    AplicatieCuBursa aplicatieCuBursa;

    @BeforeEach
    void setUp() {
        aplicatieCuBursa = new AplicatieCuBursa();
    }

    @Test
    public void sorteazaTest(){
        List<StudentBursier> list = aplicatieCuBursa.genereaza();
        list = aplicatieCuBursa.sorteaza(list);

        Assertions.assertTrue(list.size() > 0);
    }
}
