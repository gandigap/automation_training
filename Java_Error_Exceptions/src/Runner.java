import Entity.Faculty;
import Entity.Group;
import Entity.Student;
import Entity.University;
import Enums.NamesFaculties;
import Enums.NamesGroups;
import Enums.NamesSubjects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static Enums.NamesSubjects.*;
/**
 * Created by Администратор on 06.09.20.
 */
public class Runner {

    private static List<Student> studentsBes = Arrays.asList(
            new Student("Поляк А.Н", new HashMap<NamesSubjects, Integer>() {{
                put(BIOLOGY, 5);
                put(ENGLISH, 7);
                put(CHEMISTRY, 7);
            }}),
            new Student("Иванов И.И",new HashMap<NamesSubjects, Integer>() {{

                put(ENGLISH, 8);
                put(CHEMISTRY, 1);
            }}),
            new Student("Петроа и.Ю",new HashMap<NamesSubjects, Integer>() {{
                put(BIOLOGY, 3);
                put(ENGLISH, -1);
                put(CHEMISTRY, 9);
            }}),
            new Student("Зайцев М.М",new HashMap<NamesSubjects, Integer>() {{
                put(ENGLISH, 6);
            }})
    );;

    private static List<Student> studentsBas = Arrays.asList(
            new Student("Смирнов А.Н",new HashMap<NamesSubjects, Integer>() {{
                put(CHEMISTRY, 4);
                put(BIOLOGY, 4);
                put(ENGLISH, 4);

            }}),
            new Student("Зайцев Л.К",new HashMap<NamesSubjects, Integer>() {{
                put(BIOLOGY, 9);
                put(ENGLISH, 10);
                put(CHEMISTRY, 11);
            }})
    );;

    private static List<Student> studentsMac = Arrays.asList(

    );;

    private static List<Student> studentsMoc = Arrays.asList(
            new Student("Ковалева О.Н",new HashMap<NamesSubjects, Integer>() {{
                put(MATHS, 9);
                put(ENGLISH, 10);
                put(PHYSICS, 11);
            }}),
            new Student("Зайцева Г.Ж",new HashMap<NamesSubjects, Integer>() {{
            }})
    );;
//-------------------------------------------------------------------
    private static List<Group> groupBio = Arrays.asList(
            new Group(NamesGroups.BES,studentsBes ,new NamesSubjects[]{BIOLOGY, ENGLISH, CHEMISTRY}),
            new Group(NamesGroups.BAS,studentsBas, new NamesSubjects[]{BIOLOGY, ENGLISH, CHEMISTRY})
    );;

    private static List<Group> groupMec = Arrays.asList(
            new Group(NamesGroups.MAC,studentsMac, new NamesSubjects[]{MATHS, PHYSICS, ENGLISH}),
            new Group(NamesGroups.MOC,studentsMoc, new NamesSubjects[]{MATHS, PHYSICS, ENGLISH})
    );;

    private static List<Group> groupEco = Arrays.asList(

    );;
//---------------------------------------------------------------
    private static List<Faculty> faculties = Arrays.asList(
            new Faculty(NamesFaculties.BIOLOGICAL, groupBio),
            new Faculty(NamesFaculties.MECHANICAL , groupMec),
            new Faculty(NamesFaculties.ECONOMIC , groupEco)

    );


    public static void main(String[] args) {
        University university = new University(faculties);

        university.averageScoreInAllSubjectsOfTheStudent("Поляк А.Н");
        university.averageScoreInSpecificsSubjectGroupFaculty(NamesSubjects.BIOLOGY, NamesGroups.BES, NamesFaculties.BIOLOGICAL);
        university.averageGradeInASubjectForTheWholeUniversity(NamesSubjects.PHYSICS);

    }
}
