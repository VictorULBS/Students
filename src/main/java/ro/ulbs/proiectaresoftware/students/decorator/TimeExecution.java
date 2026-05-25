package ro.ulbs.proiectaresoftware.students.decorator;

import ro.ulbs.proiectaresoftware.students.Student;
import ro.ulbs.proiectaresoftware.students.strategy.StrategieOutput;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class TimeExecution implements ITimeExecution {

    StrategieOutput exporter;
    public TimeExecution(StrategieOutput exporter) {
        this.exporter = exporter;
    };

    @Override
    public long executionTime(List<Student> studenti) {
        long time = System.currentTimeMillis();
        exporter.outputStudenti(studenti);
        long execTime = System.currentTimeMillis() - time;
        return execTime;
    }


}
