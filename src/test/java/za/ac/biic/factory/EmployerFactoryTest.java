package za.ac.biic.factory;

import org.junit.jupiter.api.Test;
import za.ac.biic.domain.Employer;

import static org.junit.jupiter.api.Assertions.*;

class EmployerFactoryTest {

    @Test
    void createEmployer_ValidInput_ShouldCreateEmployer() {
        // Arrange
        int employerId = 1;
        String companyName = "Tech Solutions";
        String hrEmail = "hr@techsolutions.com";
        String password = "password123";

        // Act
        Employer employer = EmployerFactory.createEmployer(employerId, companyName, hrEmail, password);

        // Assert
        assertNotNull(employer);
        assertEquals(employerId, employer.getEmployerId());
        assertEquals(companyName, employer.getCompanyName());
        assertEquals(hrEmail, employer.getHrEmail());
        assertEquals(password, employer.getPassword());
    }

    @Test
    void createEmployer_InvalidCompanyName_ShouldThrowException() {
        // Arrange
        int employerId = 1;
        String companyName = "";
        String hrEmail = "hr@techsolutions.com";
        String password = "password123";

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployerFactory.createEmployer(employerId, companyName, hrEmail, password)
        );
        assertEquals("Company name cannot be null or empty", exception.getMessage());
    }

    @Test
    void createEmployer_InvalidHrEmail_ShouldThrowException() {
        // Arrange
        int employerId = 1;
        String companyName = "Tech Solutions";
        String hrEmail = "invalid-email";
        String password = "password123";

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployerFactory.createEmployer(employerId, companyName, hrEmail, password)
        );
        assertEquals("Invalid HR email address", exception.getMessage());
    }

    @Test
    void createEmployer_ShortPassword_ShouldThrowException() {
        // Arrange
        int employerId = 1;
        String companyName = "Tech Solutions";
        String hrEmail = "hr@techsolutions.com";
        String password = "12345";

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployerFactory.createEmployer(employerId, companyName, hrEmail, password)
        );
        assertEquals("Password must be at least 6 characters long", exception.getMessage());
    }
}
