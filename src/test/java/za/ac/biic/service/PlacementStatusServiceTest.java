package za.ac.biic.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.biic.domain.PlacementStatus;
import za.ac.biic.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PlacementStatusServiceTest {

    @Autowired
    private PlacementStatusService placementStatusService;

    private PlacementStatus status1, status2, status3;

    @BeforeEach
    void setUp() {
        Student student1 = new Student.Builder()
                .setStudentID(1L)
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setPassword("password123")
                .setCourse("Computer Science")
                .setSkills("Java, Python")
                .build();

        Student student2 = new Student.Builder()
                .setStudentID(2L)
                .setName("Alice Smith")
                .setEmail("alice.smith@example.com")
                .setPassword("password456")
                .setCourse("Software Engineering")
                .setSkills("SQL, C++")
                .build();

        status1 = new PlacementStatus.Builder()
                .setStatusID(1L)
                .setStudent(student1)
                .setStatus("Pending")
                .setDetails("Awaiting employer feedback")
                .build();

        status2 = new PlacementStatus.Builder()
                .setStatusID(2L)
                .setStudent(student2)
                .setStatus("Accepted")
                .setDetails("Offer accepted by the student")
                .build();

        status3 = new PlacementStatus.Builder()
                .setStatusID(3L)
                .setStudent(student1)
                .setStatus("Rejected")
                .setDetails("Application rejected by the employer")
                .build();

        placementStatusService.create(status1);
        placementStatusService.create(status2);
        placementStatusService.create(status3);
    }

    @Test
    void create() {
        PlacementStatus newStatus = new PlacementStatus.Builder()
                .setStatusID(4L)
                .setStudent(new Student.Builder()
                        .setStudentID(3L)
                        .setName("Bob Johnson")
                        .setEmail("bob.johnson@example.com")
                        .setPassword("password789")
                        .setCourse("Information Technology")
                        .setSkills("HTML, CSS")
                        .build())
                .setStatus("In Progress")
                .setDetails("Interview scheduled")
                .build();

        PlacementStatus created = placementStatusService.create(newStatus);
        assertNotNull(created);
        assertEquals("In Progress", created.getStatus());
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        PlacementStatus readStatus = placementStatusService.read(status3.getStatusID());
        assertNotNull(readStatus);
        assertEquals("Pending", readStatus.getStatus());
        System.out.println("Read: " + readStatus);
    }

    @Test
    void update() {
        PlacementStatus updatedStatus = new PlacementStatus.Builder()
                .copy(status2)
                .setDetails("Offer letter sent to the student")
                .build();

        PlacementStatus updated = placementStatusService.update(updatedStatus);
        assertNotNull(updated);
        assertEquals("Offer letter sent to the student", updated.getDetails());
        System.out.println("Updated: " + updated);
    }

}
