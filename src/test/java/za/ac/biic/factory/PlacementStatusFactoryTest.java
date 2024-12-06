package za.ac.biic.factory;

import org.junit.jupiter.api.Test;
import za.ac.biic.domain.PlacementStatus;
import za.ac.biic.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

class PlacementStatusFactoryTest {

    @Test
    void createPlacementStatus_Success() {

        Long statusID = 1L;
        Student student = new Student.Builder()
                .setStudentID(101L)
                .setName("Alice Smith")
                .setEmail("alice.smith@example.com")
                .setPassword("password123")
                .setCourse("Information Technology")
                .setSkills("Java, SQL")
                .build();
        String status = "Placed";
        String details = "Hired as a Software Engineer at XYZ Corp";

        PlacementStatus createdPlacementStatus = PlacementStatusFactory.createPlacementStatus(statusID, student, status, details);

        assertNotNull(createdPlacementStatus);
        assertEquals(statusID, createdPlacementStatus.getStatusID());
        assertEquals(student, createdPlacementStatus.getStudent());
        assertEquals(status, createdPlacementStatus.getStatus());
        assertEquals(details, createdPlacementStatus.getDetails());
    }

    @Test
    void createPlacementStatus_Fail() {

        Long statusID = null;
        Student student = null;
        String status = "";
        String details = "";

        PlacementStatus createdPlacementStatus = PlacementStatusFactory.createPlacementStatus(statusID, student, status, details);

        assertNull(createdPlacementStatus, "Expected null when invalid inputs are provided");
    }
}