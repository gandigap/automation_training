package Entity;

import Enums.NamesSubjects;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by Администратор on 06.09.20.
 */
public class Student {

    private String name;
    private HashMap <NamesSubjects, Integer> listMarksyBySubjects;

    public Student(String name, HashMap<NamesSubjects, Integer> listMarks)  {
        /*if(listMarksyBySubjects.isEmpty()) try {
            throw new ExceptionStudentHasNotSubjects("У студента нет оценок по предметам");
        } catch (ExceptionStudentHasNotSubjects exceptionStudentHasNotSubjects) {
            System.out.println(exceptionStudentHasNotSubjects);;
        }*/
        this.name = name;
        this.listMarksyBySubjects = listMarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<NamesSubjects, Integer> getListMarksyBySubjects() {
        return listMarksyBySubjects;
    }

    public void setListMarksyBySubjects(HashMap<NamesSubjects, Integer> listMarksyBySubjects) {
        this.listMarksyBySubjects = listMarksyBySubjects;
    }

    public double getAverage(){
        double sum = 0;
        for (Map.Entry<NamesSubjects, Integer> entry : listMarksyBySubjects.entrySet()) {
            sum += entry.getValue().doubleValue();
        }
        return sum / listMarksyBySubjects.size();
    }

    public boolean checkStudentHasSubject(NamesSubjects nameSubject){
        boolean result = false;
        for (Map.Entry<NamesSubjects, Integer> entry : listMarksyBySubjects.entrySet()) {
            if(entry.getKey().equals(nameSubject)){
                return true;
            }
        }
        return result;
    }

    public int getMark(NamesSubjects nameSubject){
        int mark = 0;
        for (Map.Entry<NamesSubjects, Integer> entry : listMarksyBySubjects.entrySet()) {
            if(entry.getKey().equals(nameSubject)){
                mark = entry.getValue();
            }
        }
        return mark;
    }
}
