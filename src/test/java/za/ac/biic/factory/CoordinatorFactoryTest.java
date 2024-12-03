package za.ac.biic.factory;

import org.junit.jupiter.api.Test;
import za.ac.biic.domain.Coordinator;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatorFactoryTest {

    @Test
    void createCoordinator_ValidInput_ShouldCreateCoordinator() {
        // Arrange
        int coordinatorId = 1;
        String name = "John Doe";
        String email = "john.doe@example.com";
        String password = "password123";

        // Act
        Coordinator coordinator = CoordinatorFactory.createCoordinator(coordinatorId, name, email, password);

        // Assert
        assertNotNull(coordinator);
        assertEquals(coordinatorId, coordinator.getCoordinatorId());
        assertEquals(name, coordinator.getName());
        assertEquals(email, coordinator.getEmail());
        assertEquals(password, coordinator.getPassword());
    }

    @Test
    void createCoordinator_InvalidName_ShouldThrowException() {
        // Arrange
        int coordinatorId = 1;
        String name = "";
        String email = "john.doe@example.com";
        String password = "password123";

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CoordinatorFactory.createCoordinator(coordinatorId, name, email, password)
        );
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }

    @Test
    void createCoordinator_InvalidEmail_ShouldThrowException() {
        // Arrange
        int coordinatorId = 1;
        String name = "John Doe";
        String email = "invalid-email";
        String password = "password123";

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CoordinatorFactory.createCoordinator(coordinatorId, name, email, password)
        );
        assertEquals("Invalid email address", exception.getMessage());
    }

    @Test
    void createCoordinator_ShortPassword_ShouldThrowException() {
        // Arrange
        int coordinatorId = 1;
        String name = "John Doe";
        String email = "john.doe@example.com";
        String password = "12345";

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CoordinatorFactory.createCoordinator(coordinatorId, name, email, password)
        );
        assertEquals("Password must be at least 6 characters long", exception.getMessage());
    }
}
