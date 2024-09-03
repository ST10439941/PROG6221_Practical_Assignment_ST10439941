package Q1_Test;

import Question_1.Student;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {

    @Before
    public void setUp() {
        //clear the student list before each test
        Student.getStudentList().clear();
    }

    @After
    public void tearDown() {
        //clear the student list after each test
        Student.getStudentList().clear();
    }

    @Test //tests if the student is saved to the arraylist
    public void TestSaveStudent() {
        System.out.println("\n#############################");
        System.out.println("TEST STUDENT SAVE");
        System.out.println("#############################");
        
        //dummy data
        int id = 10111;
        String name = "C.Kent";
        int age = 19;
        String email = "ckent@ymail.com";
        String course = "disd";
        
        //saves data to array by calling method from Student class
        Student.SaveStudent(id, name, age, email, course);
        
        //assert for test pass or fail
        ArrayList<Student> students = Student.getStudentList();
        assertEquals(1, students.size());
        Student student = students.get(0);
        assertEquals(id, student.getId());
        assertEquals(name, student.getName());
        assertEquals(age, student.getAge());
        assertEquals(email, student.getEmail());
        assertEquals(course, student.getCourse());
    }

    @Test //tests to search for a student
    public void TestSearchStudent() {
        System.out.println("\n#############################");
        System.out.println("TEST SEARCH STUDENT");
        System.out.println("#############################");
        
        //dummy data
        int id = 10112;
        String name = "L.Howes";
        int age = 21;
        String email = "lhowes@ymail.com";
        String course = "disd";
        
        //save the student first before searching
        Student.SaveStudent(id, name, age, email, course);
       
        //calls search method from student class
        Student result = Student.SearchStudent(id);
        
        //assert for test pass or fail
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(name, result.getName());
        assertEquals(age, result.getAge());
        assertEquals(email, result.getEmail());
        assertEquals(course, result.getCourse());
    }

    @Test // test checks if if a student is not found
    public void TestSearchStudent_StudentNotFound() {
        System.out.println("\n#############################");
        System.out.println(" TEST SEARCH - STUDENT NOT FOUND");
        System.out.println("#############################");
        
        //input 999 to display no student found
        Student result = Student.SearchStudent(999);
        
        //assert for test pass or fail
        assertNull(result);
    }

    @Test //test is to delete a student from the arraylist
    public void TestDeleteStudent() {
        System.out.println("\n#############################");
        System.out.println("TEST DELETE STUDENT");
        System.out.println("#############################");
        
        //dummy Data
        int id = 10113;
        String name = "P.Parker";
        int age = 20;
        String email = "spidey@ymail.com";
        String course = "disn";
        
        Student.SaveStudent(id, name, age, email, course);
        
        //calls the delete method from Student class
        Student.DeleteStudent(id);
        
        //assert for test pass or fail
        ArrayList<Student> students = Student.getStudentList();
        assertEquals(0, students.size());
    }

    @Test //test checks if students are not found in the delete method
    public void TestDeleteStudent_StudentNotFound() {
        System.out.println("\n##################################");
        System.out.println("TEST DELETE - STUDENT NOT FOUND");
        System.out.println("##################################");
        
        //dummy Data
        int initialSize = Student.getStudentList().size();
        
        //input 999 to test student not found
        Student.DeleteStudent(999);
        
        //assert for test pass or fail
        ArrayList<Student> students = Student.getStudentList();
        assertEquals(initialSize, students.size());
    }

    @Test //test checks that student ages are valid
    public void TestStudentAge_StudentAgeValid() {
        System.out.println("\n#############################");
        System.out.println("TEST STUDENT AGE VALID");
        System.out.println("#############################");
        
        //dummy Data
        int id = 10114;
        String name = "S.Cooper";
        int age = 30;
        String email = "scooper@ymail.com";
        String course = "disd";
        
        //saves data to array by calling method from Student class
        Student.SaveStudent(id, name, age, email, course);
        
        //assert for test pass or fail
        ArrayList<Student> students = Student.getStudentList();
        assertEquals(1, students.size());
        Student student = students.get(0);
        assertEquals(age, student.getAge());
    }

    @Test //test checks that student ages are invalid
    public void TestStudentAge_StudentAgeInvalid() {
        System.out.println("\n#############################");
        System.out.println("TEST STUDENT AGE INVALID");
        System.out.println("#############################");
        
        //dummy Data
        int id = 10115;
        String name = "L.Skywalker";
        int age = 15; // Invalid age
        String email = "lskywalker@ymail.com";
        String course = "disd";
        
        //saves data to array by calling method from Student class
        Student.SaveStudent(id, name, age, email, course);
        
        //assert for test pass or fail
        ArrayList<Student> students = Student.getStudentList();
        assertEquals(1, students.size()); // Invalid age, student should not be added
    }

    @Test //test checks that student ages have invalid characters
    public void TestStudentAge_StudentAgeInvalidCharacter() {
        System.out.println("\n###########################################");
        System.out.println("TEST STUDENT AGE INVALID WITH CHARACTER");
        System.out.println("###########################################");
        
        //dummy Data
        int id = 10116;
        String name = "B.Joffe";
        int age = 'A'; //invalid age character
        String email = "bjoffe@ymail.com";
        String course = "disd";
        
        //saves data to array by calling method from Student class
        Student.SaveStudent(id, name, age, email, course);
        
        //assert for test pass or fail
        ArrayList<Student> students = Student.getStudentList();
        assertEquals(1, students.size()); // Invalid character, student should not be added
    }
}
