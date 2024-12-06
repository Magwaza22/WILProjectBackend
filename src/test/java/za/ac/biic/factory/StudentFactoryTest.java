package za.ac.biic.factory;

import org.junit.jupiter.api.Test;
import za.ac.biic.domain.Student;

import static org.junit.jupiter.api.Assertions.*;
class StudentFactoryTest {

    @Test
    void createStudent_Success() {
        Long studentID = 1L;
        String name = "John Doe";
        String email = "john.doe@example.com";
        String password = "password123";
        String course = "Computer Science";
        String skills = "Java, Python";

        Student createdStudent = StudentFactory.createStudent(studentID, name, email, password, course, skills);

        assertNotNull(createdStudent);
        assertEquals(studentID, createdStudent.getStudentID());
        assertEquals(name, createdStudent.getName());
        assertEquals(email, createdStudent.getEmail());
        assertEquals(password, createdStudent.getPassword());
        assertEquals(course, createdStudent.getCourse());
        assertEquals(skills, createdStudent.getSkills());
    }

    @Test
    void createStudent_Fail() {
        Long studentID = null;
        String name = "";
        String email = null;
        String password = "";
        String course = null;
        String skills = "";

        Student createdStudent = StudentFactory.createStudent(studentID, name, email, password, course, skills);

        assertNull(createdStudent, "Expected null when invalid inputs are provided");
    }
}