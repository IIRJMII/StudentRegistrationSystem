import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;

public class Student {
    private String name;
    private int age;
    private DateTime DOB;
    private int ID;
    private String username;
    private ArrayList<CourseProgramme> courses = new ArrayList<>();
    private ArrayList<Module> modules = new ArrayList<>();

    public Student(String name, DateTime DOB, int ID) {
        this.name = name;
        this.DOB = DOB;
        this.age = getAge();
        this.ID = ID;
        this.username = getUsername();
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return Years.yearsBetween(this.DOB, new DateTime()).getYears();
    }

    public DateTime getDOB() {
        return this.DOB;
    }

    public int getID() {
        return this.ID;
    }

    public String getUsername() {
        return this.name + this.age;
    }

    public ArrayList<CourseProgramme> getCourses() {
        return this.courses;
    }

    public ArrayList<Module> getModules() {
        return this.modules;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDOB(DateTime DOB) {
        this.DOB = DOB;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void addCourse(CourseProgramme course) {
        if(!this.courses.contains(course)) {
            this.courses.add(course);
            course.addStudent(this);
        }
    }

    public void removeCourse(CourseProgramme course) {
        if(this.courses.contains(course)) {
            this.courses.remove(course);
            course.removeStudent(this);
        }
    }

    public void addModule(Module module) {
        if(!this.modules.contains(module)) {
            this.modules.add(module);
            module.addStudent(this);
        }
    }

    public void removeModule(Module module) {
        if(this.modules.contains(module)) {
            this.modules.remove(module);
            module.removeStudent(this);
        }
    }

    public static void main(String args[]) {
        Student s = new Student("Robert", new DateTime("1998-05-18"), 17431096);
        System.out.println("Student name: " + s.getName());
        System.out.println("Student age: " + s.getAge());
        System.out.println("Student DOB: " + s.getDOB().toString(DateTimeFormat.shortDate()));
        System.out.println("Student ID: " + s.getID());
        System.out.println("Student username: " + s.getUsername());
        //s.addCourse("GY350");
        System.out.println("Student courses: " + s.getCourses());
        //s.addModule("CT101");
        //s.addModule("CT102");
        System.out.println("Student modules: " + s.getModules());
    }
}
