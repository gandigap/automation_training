package Entity;

import Enums.NamesGroups;
import Enums.NamesSubjects;

import java.util.List;

/**
 * Created by Администратор on 06.09.20.
 */
public class Group {
    private NamesGroups nameGroup;
    private List<Student> listStudents;

    public Group(NamesGroups nameGroup, List<Student> listStudents, NamesSubjects [] listSublects ) {
        this.nameGroup = nameGroup;
        this.listStudents = listStudents;
    }

    public NamesGroups getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(NamesGroups nameGroup) {
        this.nameGroup = nameGroup;
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }

    public boolean checkStudentByGroup(String name){
        boolean result = false;
        for (Student student : listStudents) {
            if(student.getName().equals(name)){
                result = true;
            }
        }
        return result;
    }

    public double getAverageMarksStudent(String name){
        Double average = Double.valueOf(0);
        for (Student student: listStudents) {
            if(student.getName().equals(name)){
                average = student.getAverage();
            }
        }
        return average;
    }

    public void checkGroupHasSublect(NamesSubjects nameSubject){

    }
}
