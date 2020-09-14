package Entity;

import Enums.NamesFaculties;
import Enums.NamesGroups;

import java.util.List;

/**
 * Created by Администратор on 06.09.20.
 */
public class Faculty {

    private NamesFaculties nameFaculty;
    private List<Group> groups;

    public Faculty(NamesFaculties nameFaculty, List<Group> groups) {
        this.nameFaculty = nameFaculty;
        /*if(groups.isEmpty()) try {
            throw new ExceptionFacultyHasNotGroups("В университе нет факультетов");
        } catch (ExceptionFacultyHasNotGroups exceptionFacultyHasNotGroups) {
            System.out.println(exceptionFacultyHasNotGroups);
        }*/
        this.groups = groups;
    }

    public NamesFaculties getNameFaculty() {
        return nameFaculty;
    }

    public void setNameFaculty(NamesFaculties nameFaculty) {
        this.nameFaculty = nameFaculty;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public boolean facultyHasASpecificGroup(NamesGroups nameGroup){
        boolean hasGroup = false;
        for (Group group : groups) {
            if(group.getNameGroup().equals(nameGroup)){
                hasGroup = true;
            }
        }
        return hasGroup;
    }

    public int getNumberGroupByName(NamesGroups nameGroup) {
        int numberGroup = -1;
        for (Group group : groups) {
            if(group.getNameGroup().equals(nameGroup)){
                numberGroup = groups.indexOf(group);
            }
        }
        return numberGroup;
    }
}
