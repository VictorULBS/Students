package ro.ulbs.proiectaresoftware.students;

public class Student {
    int numarMatricol;
    String prenume;
    String nume;
    String formatieDeStudiu;
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

    @Override
    public String toString() {
        String s = String.format("%13d %10s %10s %s ", numarMatricol, prenume, nume, formatieDeStudiu);
        String header = "";
        if(!headerPrinted){
            header = String.format("%10s %10s %10s %10s%n", "numarMatricol", "Nume", "Prenume", "formatieDeStudiu");
            headerPrinted = true;
        }
        return header + s;
    }
}
