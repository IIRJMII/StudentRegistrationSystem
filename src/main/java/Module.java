import java.util.ArrayList;

public class Module {
    private String name;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<CourseProgramme> courses = new ArrayList<>();

    public Module(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public ArrayList<CourseProgramme> getCourses() {
        return this.courses;
    }

    public void addStudent(Student student) {
        if(!this.students.contains(student)) {
            this.students.add(student);
            student.addModule(this);
        }
    }

    public void removeStudent(Student student) {
        if(this.students.contains(student)) {
            this.students.remove(student);
            student.removeModule(this);
        }
    }

    public void addCourse(CourseProgramme course) {
        if(!this.courses.contains(course)) {
            this.courses.add(course);
            course.addModule(this);
        }
    }

    public void removeCourse(CourseProgramme course) {
        if(this.courses.contains(course)) {
            this.courses.remove(course);
            course.removeModule(this);
        }
    }
}
