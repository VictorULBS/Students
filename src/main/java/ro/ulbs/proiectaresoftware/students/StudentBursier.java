package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class StudentBursier extends Student{

    double cuantumBursa;
    public StudentBursier(Student student, double nota, double cuantumBursa) {
        super(student.getNumarMatricol(), student.getPrenume(), student.getNume(), student.getFormatieDeStudiu());
        this.nota = nota;
        this.cuantumBursa = cuantumBursa;
    }

    @Override
    public String toString() {
        return "StudentBursier{" +
                "cuantumBursa=" + cuantumBursa +
                ", numarMatricol=" + numarMatricol +
                ", prenume='" + prenume + '\'' +
                ", nume='" + nume + '\'' +
                ", formatieDeStudiu='" + formatieDeStudiu + '\'' +
                ", nota=" + nota +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentBursier that = (StudentBursier) o;
        return Double.compare(cuantumBursa, that.cuantumBursa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }
}
