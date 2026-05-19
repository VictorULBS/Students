package ro.ulbs.proiectaresoftware.students;

/*
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentiDinFisierXlsx implements StrategieInput {
    @Override
    public List<Student> inputStudenti() {
        String file = "students.xlsx";
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
}
*/