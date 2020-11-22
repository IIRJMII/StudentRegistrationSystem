import org.joda.time.DateTime;
import org.joda.time.Years;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {

    Student s1 = new Student("Elliott", new DateTime("1997-01-27"), 19384753);
    Student s2 = new Student("Angela", new DateTime("1996-08-11"), 19482057);
    Student s3 = new Student("Darlene", new DateTime("1999-04-05"), 17502857);

    Module m1 = new Module("Software Engineering");
    Module m2 = new Module("Machine Learning");
    Module m3 = new Module("Information Retrieval");

    CourseProgramme c1 = new CourseProgramme("GY350", new DateTime("2020-09-01"), new DateTime("2021-06-01"));
    CourseProgramme c2 = new CourseProgramme("GY540", new DateTime("2020-09-01"), new DateTime("2021-06-01"));

    @Test
    void studentGetterSetter() {
        String newName = "Tyler";
        DateTime newDOB = new DateTime("1999-09-10");
        int newID = 69013471;

        //change the name, DOB, ID
        s1.setName(newName);
        s1.setDOB(newDOB);
        s1.setID(newID);

        //check that the name, DOB, ID have been changed and the right age is calculated
        assertEquals(newName, s1.getName());
        assertEquals(Years.yearsBetween(newDOB, new DateTime()).getYears(), s1.getAge());
        assertEquals(newDOB, s1.getDOB());
        assertEquals(newID, s1.getID());
    }

    @Test
    void studentAddRemoveGetModules() {
        //add 3 modules to student
        s1.addModule(m1);
        s1.addModule(m2);
        s1.addModule(m3);

        //check all 3 modules have been added
        assertTrue(s1.getModules().contains(m1));
        assertTrue(s1.getModules().contains(m2));
        assertTrue(s1.getModules().contains(m3));

        //check student has been added to each of the modules
        assertTrue(m1.getStudents().contains(s1));
        assertTrue(m2.getStudents().contains(s1));
        assertTrue(m3.getStudents().contains(s1));

        //remove module 1
        s1.removeModule(m1);

        //check that only module 1 has been removed
        assertFalse(s1.getModules().contains(m1));
        assertTrue(s1.getModules().contains(m2));
        assertTrue(s1.getModules().contains(m3));

        //check that student has been removed from module 1
        assertFalse(m1.getStudents().contains(s1));

    }

    @Test
    public void studentAddRemoveGetCourses() {
        //add courses to student
        s1.addCourse(c1);
        s1.addCourse(c2);

        //check that the courses have been added to student
        assertTrue(s1.getCourses().contains(c1));
        assertTrue(s1.getCourses().contains(c2));

        //check that student has been added to courses
        assertTrue(c1.getStudents().contains(s1));
        assertTrue(c2.getStudents().contains(s1));

        //remove course 1 from student
        s1.removeCourse(c1);

        //check that only course 1 has been removed from student
        assertFalse(s1.getCourses().contains(c1));
        assertTrue(s1.getCourses().contains(c2));

        //check that student has been removed from course 1
        assertFalse(c1.getStudents().contains(s1));
    }

    @Test
    public void moduleGetterSetter() {
        //change name of module
        m1.setName("Programming");

        //check the module name has been changed
        assertEquals("Programming", m1.getName());
    }

    @Test
    public void moduleAddRemoveGetStudents() {
        //add students to module
        m1.addStudent(s1);
        m1.addStudent(s2);
        m1.addStudent(s3);

        //check that the students have been added to module
        assertTrue(m1.getStudents().contains(s1));
        assertTrue(m1.getStudents().contains(s2));
        assertTrue(m1.getStudents().contains(s3));

        //check that the module has been added to students
        assertTrue(s1.getModules().contains(m1));
        assertTrue(s2.getModules().contains(m1));
        assertTrue(s3.getModules().contains(m1));

        //remove student 1 from module
        m1.removeStudent(s1);

        //check that only student 1 has been removed from the module
        assertFalse(m1.getStudents().contains(s1));
        assertTrue(m1.getStudents().contains(s2));
        assertTrue(m1.getStudents().contains(s3));

        //check that module has been removed from student
        assertFalse(s1.getModules().contains(m1));

    }

    @Test
    public void moduleAddRemoveGetCourses() {
        //add courses to module
        m1.addCourse(c1);
        m1.addCourse(c2);

        //check that the courses have been added to module
        assertTrue(m1.getCourses().contains(c1));
        assertTrue(m1.getCourses().contains(c2));

        //check that the module has been added to courses
        assertTrue(c1.getModules().contains(m1));
        assertTrue(c2.getModules().contains(m1));

        //remove course 1 from module
        m1.removeCourse(c1);

        //check that only course 1 was removed from the module
        assertFalse(m1.getCourses().contains(c1));
        assertTrue(m1.getCourses().contains(c2));

        //check that the module has been removed from course 1
        assertFalse(c1.getModules().contains(m1));
    }

    @Test
    public void courseProgrammeAddRemoveGetStudents() {
        //add students to course
        c1.addStudent(s1);
        c1.addStudent(s2);
        c1.addStudent(s3);

        //check that the students have been added to course
        assertTrue(c1.getStudents().contains(s1));
        assertTrue(c1.getStudents().contains(s2));
        assertTrue(c1.getStudents().contains(s3));

        //check that the course has been added to students
        assertTrue(s1.getCourses().contains(c1));
        assertTrue(s2.getCourses().contains(c1));
        assertTrue(s3.getCourses().contains(c1));

        //remove student 1 from course
        c1.removeStudent(s1);

        //check that only student 1 has been removed
        assertFalse(c1.getStudents().contains(s1));
        assertTrue(c1.getStudents().contains(s2));
        assertTrue(c1.getStudents().contains(s3));

        //check that the course has been removed from student 1
        assertFalse(s1.getCourses().contains(c1));
    }

    @Test
    public void courseProgrammeAddRemoveGetModules() {
        //add modules to course
        c1.addModule(m1);
        c1.addModule(m2);
        c1.addModule(m3);

        //check that modules have been added to course
        assertTrue(c1.getModules().contains(m1));
        assertTrue(c1.getModules().contains(m2));
        assertTrue(c1.getModules().contains(m3));

        //check that course has been added to modules
        assertTrue(m1.getCourses().contains(c1));
        assertTrue(m2.getCourses().contains(c1));
        assertTrue(m3.getCourses().contains(c1));

        //remove module 1
        c1.removeModule(m1);

        //check that only module 1 has been removed from course
        assertFalse(c1.getModules().contains(m1));
        assertTrue(c1.getModules().contains(m2));
        assertTrue(c1.getModules().contains(m3));

        //check that course has been removed from module 1
        assertFalse(m1.getCourses().contains(c1));
    }
}
