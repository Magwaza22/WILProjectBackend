package za.ac.biic.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.biic.domain.Student;
import za.ac.biic.factory.StudentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/WILProjectBackend/student";
    private static Student student;
    //private static StudentController studentController;

    @BeforeAll
    public static void setUp() {
        student = StudentFactory.createStudent(1L, "John Doe", "johndoe@example.com", "encrypt23",
                "Computer Science", "Java, Python");
    }


    @Test
    void save() {
        String url = BASE_URL + "/save";
        ResponseEntity<Student> postResponse = restTemplate.postForEntity(url, student, Student.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        Student studentSaved = postResponse.getBody();
        assertEquals(student.getStudentID(), studentSaved.getStudentID());
        System.out.println("Saved data:" + studentSaved);
    }

    @Test
    void read() {
        String url = BASE_URL + "/read/" + student.getStudentID();
        ResponseEntity<Student> response = restTemplate.getForEntity(url, Student.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(student.getStudentID(), response.getBody().getStudentID());
        System.out.println("Read: {}" + response.getBody());
    }

    @Test
    void deleteByID() {
        String url = BASE_URL + "/deletebyid/" + student.getStudentID();
        restTemplate.delete(url);
        System.out.println("Deleted student with ID: {}"+student.getStudentID());
    }

    @Test
    void getAll() {
        String url = BASE_URL + "/getall";
        ResponseEntity<Student[]> response = restTemplate.getForEntity(url, Student[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
        System.out.println("Fetched all students: {}" + Arrays.toString(response.getBody()));
    }
}