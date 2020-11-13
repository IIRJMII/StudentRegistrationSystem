import org.joda.time.DateTime;

import java.util.ArrayList;

public class CourseProgramme {
    private String name;
    private ArrayList<Module> modules = new ArrayList<Module>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private DateTime academicStartDate;
    private DateTime academicEndDate;

    public CourseProgramme(String name, DateTime academicStartDate, DateTime academicEndDate) {
        this.name = name;
        this.academicStartDate = academicStartDate;
        this.academicEndDate = academicEndDate;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Module> getModules() {
        return this.modules;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public DateTime getAcademicStartDate() {
        return this.academicStartDate;
    }

    public DateTime getAcademicEndDate() {
        return this.academicEndDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcademicStartDate(DateTime academicStartDate) {
        this.academicStartDate = academicStartDate;
    }

    public void setAcademicEndDate(DateTime academicEndDate) {
        this.academicEndDate = academicEndDate;
    }

    public void addStudent(Student student) {
        if(!this.students.contains(student)) {
            this.students.add(student);
            student.addCourse(this);
        }
    }

    public void removeStudent(Student student) {
        if(this.students.contains(student)) {
            this.students.remove(student);
            student.removeCourse(this);
        }
    }

    public void addModule(Module module) {
        if(!this.modules.contains(module)) {
            this.modules.add(module);
            module.addCourse(this);
        }
    }

    public void removeModule(Module module) {
        if(this.modules.contains(module)) {
            this.modules.remove(module);
            module.removeCourse(this);
        }
    }
}
