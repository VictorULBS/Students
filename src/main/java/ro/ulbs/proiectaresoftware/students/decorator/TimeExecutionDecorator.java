package ro.ulbs.proiectaresoftware.students.decorator;

import ro.ulbs.proiectaresoftware.students.Student;
import ro.ulbs.proiectaresoftware.students.strategy.StrategieOutput;

import java.util.List;

public class TimeExecutionDecorator extends TimeExecution {
    List<Student> studenti;
    public TimeExecutionDecorator(StrategieOutput exporter, List<Student> studenti) {
        super(exporter);
        this.studenti = studenti;
    }

    public long executionTime(){
        long execTime = super.executionTime(studenti);
        return execTime;
    }
}
