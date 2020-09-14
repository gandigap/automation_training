package Entity;

import Enums.NamesFaculties;
import Enums.NamesGroups;
import Enums.NamesSubjects;

import java.util.ArrayList;
import java.util.List;

import static Entity.StringConstants.*;
/**
 * Created by Администратор on 06.09.20.
 */
public class University {

    private List<Faculty> faculties = new ArrayList<Faculty>();

    public University(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void addFacultyInUniversity(ArrayList<Faculty> universityList)  {

        this.faculties = universityList;
    }

    public void averageScoreInAllSubjectsOfTheStudent(String nameStudent) {
        for (Faculty faculty: faculties) {
            for (Group group : faculty.getGroups()) {
                if(group.checkStudentByGroup(nameStudent)){
                    System.out.println(AVERAGE_SCORE_IN_ALL_SUBJECTS + nameStudent + IS
                            + group.getAverageMarksStudent(nameStudent) + GROUP + group.getNameGroup());
                }
            }
        }
    }

    public int getNumberFacultyByName(NamesFaculties nameFaculty){
        int numberFaculty = -1;
        for (Faculty faculty : faculties) {
            if(faculty.getNameFaculty().equals(nameFaculty)){
                numberFaculty = faculties.indexOf(faculty);
            }
        }
        return numberFaculty;
    }

    public void averageScoreInSpecificsSubjectGroupFaculty(NamesSubjects nameSubject, NamesGroups nameGroup, NamesFaculties nameFaculty) {
        double sumMarksBySubject = 0;
        double average = 0;
        int numberFaculty = getNumberFacultyByName(nameFaculty);
        if(numberFaculty >= 0){
            Faculty facultyByName = faculties.get(numberFaculty);
            int numberGroup = facultyByName.getNumberGroupByName(nameGroup);
            if( numberGroup >= 0){
                Group groupByName = facultyByName.getGroups().get(numberGroup);
                for (Student student : groupByName.getListStudents()) {
                    if(student.checkStudentHasSubject(nameSubject)){
                        sumMarksBySubject += student.getMark(nameSubject);
                    }
                }
                average = sumMarksBySubject / groupByName.getListStudents().size();
            }
        }
        System.out.println("Cредний балл по " + nameSubject + " в группе " + nameGroup +
                " на факультете " + nameFaculty + " равен  " + average );
    }

    public void averageGradeInASubjectForTheWholeUniversity(NamesSubjects nameSubject) {
        double sumMarksBySubject = 0;
        double average = 0;
        int countStudentsWithMarkBySubject = 0;
        for (Faculty faculty: faculties) {
            for (Group group : faculty.getGroups()) {
                for (Student student: group.getListStudents()) {
                    if(student.checkStudentHasSubject(nameSubject)){
                        sumMarksBySubject += student.getMark(nameSubject);
                        countStudentsWithMarkBySubject++;
                    }
                }
            }
        }
        average = sumMarksBySubject / countStudentsWithMarkBySubject;
        System.out.println("Cредний балл по предмету " +nameSubject + " для всего университета составляет " + average);
    }
}
