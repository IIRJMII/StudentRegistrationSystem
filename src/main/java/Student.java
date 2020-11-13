import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;

public class Student {
    private String name;
    private int age;
    private DateTime DOB;
    private int ID;
    private String username;
    private ArrayList<String> courses = new ArrayList<String>();
    private ArrayList<String> modules = new ArrayList<String>();

    public Student(String name, int age, DateTime DOB, int ID) {
        this.name = name;
        this.age = age;
        this.DOB = DOB;
        this.ID = ID;
        this.username = getUsername();
    }

    private String getName() {
        return this.name;
    }

    private int getAge() {
        return this.age;
    }

    private DateTime getDOB() {
        return this.DOB;
    }

    private int getID() {
        return this.ID;
    }

    private String getUsername() {
        return this.name + this.age;
    }

    private ArrayList<String> getCourses() {
        return this.courses;
    }

    private ArrayList<String> getModules() {
        return this.modules;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setDOB(DateTime DOB) {
        this.DOB = DOB;
    }

    private void setID(int ID) {
        this.ID = ID;
    }

    private void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    private void setModules(ArrayList<String> modules) {
        this.modules = modules;
    }

    private void addCourse(String course) {
        this.courses.add(course);
    }

    private void addModule(String module) {
        this.modules.add(module);
    }
    private void removeCourse(String course) {
        this.courses.remove(course);
    }

    private void removeModule(String module) {
        this.courses.remove(module);
    }

    public static void main(String args[]) {
        Student s = new Student("Robert", 22, new DateTime("1998-05-18"), 17431096);
        System.out.println("Student name: " + s.getName());
        System.out.println("Student age: " + s.getAge());
        System.out.println("Student DOB: " + s.getDOB().toString(DateTimeFormat.shortDate()));
        System.out.println("Student ID: " + s.getID());
        System.out.println("Student username: " + s.getUsername());
        s.addCourse("GY350");
        System.out.println("Student courses: " + s.getCourses());
        s.addModule("CT101");
        s.addModule("CT102");
        System.out.println("Student modules: " + s.getModules());
    }
}
