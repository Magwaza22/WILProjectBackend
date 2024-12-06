package za.ac.biic.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.biic.domain.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    private Student student1, student2, student3;

    @BeforeEach
    void setUp() {
        student1 = new Student.Builder()
                .setStudentID(1L)
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setPassword("password123")
                .setCourse("Computer Science")
                .setSkills("Java, Python")
                .build();

        student2 = new Student.Builder()
                .setStudentID(2L)
                .setName("Alice Smith")
                .setEmail("alice.smith@example.com")
                .setPassword("password456")
                .setCourse("Software Engineering")
                .setSkills("SQL, C++")
                .build();

        student3 = new Student.Builder()
                .setStudentID(3L)
                .setName("Bob Johnson")
                .setEmail("bob.johnson@example.com")
                .setPassword("password789")
                .setCourse("Information Technology")
                .setSkills("HTML, CSS")
                .build();

        studentService.create(student1);
        studentService.create(student2);
        studentService.create(student3);
    }

    @Test
    void create() {
        Student newStudent = new Student.Builder()
                .setStudentID(4L)
                .setName("Jane Doe")
                .setEmail("jane.doe@example.com")
                .setPassword("password321")
                .setCourse("Data Science")
                .setSkills("R, Machine Learning")
                .build();

        Student created = studentService.create(newStudent);
        assertNotNull(created);
        assertEquals(newStudent.getStudentID(), created.getStudentID());
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        Student readStudent = studentService.read(student3.getStudentID());
        assertNotNull(readStudent);
        assertEquals(student3.getName(), readStudent.getName());
        System.out.println("Read: " + readStudent);
    }

    @Test
    void update() {
        Student updatedStudent = new Student.Builder()
                .copy(student2)
                .setCourse("Artificial Intelligence")
                .build();

        Student updated = studentService.update(updatedStudent);
        assertNotNull(updated);
        assertEquals("Artificial Intelligence", updated.getCourse());
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        studentService.delete(student1.getStudentID());
        Student deletedStudent = studentService.read(student1.getStudentID());
        assertNull(deletedStudent, "Deleted student should not exist");
        System.out.println("Deleted student with ID: " + student1.getStudentID());
    }

    @Test
    void getAll() {
        List<Student> students = studentService.getall();
        assertNotNull(students);
        assertEquals(3, students.size(), "There should be 3 students in the database");
        System.out.println("All Students: " + students);
    }
}
