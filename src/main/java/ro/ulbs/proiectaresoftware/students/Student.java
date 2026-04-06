package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class Student {
    int numarMatricol;
    String prenume;
    String nume;
    String formatieDeStudiu;
    Double nota;
    static boolean headerPrinted = false;

    public Student(int numarMatricol, String prenume, String nome, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nome;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public int getNumarMatricol() {
        return numarMatricol;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }

    public Double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        String s = String.format("%13d %10s %10s %16s %10f", numarMatricol, prenume, nume, formatieDeStudiu, nota);
        String header = "";
        if(!headerPrinted){
            header = String.format("%10s %10s %10s %10s %10s%n", "numarMatricol", "Nume", "Prenume", "formatieDeStudiu", "Nota");
            headerPrinted = true;
        }
        return header + s;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return numarMatricol == student.numarMatricol &&
                nota == student.nota &&
                Objects.equals(prenume, student.prenume) &&
                Objects.equals(nume, student.nume) &&
                Objects.equals(formatieDeStudiu, student.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol, prenume, nume, formatieDeStudiu, nota);
    }
}
