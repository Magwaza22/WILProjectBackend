package za.ac.biic.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.biic.domain.Coordinator;
import za.ac.biic.repository.CoordinatorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CoordinatorServiceTest {

    @Mock
    private CoordinatorRepository coordinatorRepository;

    @InjectMocks
    private CoordinatorService coordinatorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create_ShouldSaveAndReturnCoordinator() {
        // Arrange
        Coordinator coordinator = new Coordinator.Builder()
                .setCoordinatorId(1)
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setPassword("securepassword")
                .build();

        when(coordinatorRepository.save(coordinator)).thenReturn(coordinator);

        // Act
        Coordinator savedCoordinator = coordinatorService.create(coordinator);

        // Assert
        assertNotNull(savedCoordinator);
        assertEquals(coordinator, savedCoordinator);
        verify(coordinatorRepository, times(1)).save(coordinator);
    }

    @Test
    void read_ShouldReturnCoordinatorWhenFound() {
        // Arrange
        int coordinatorId = 1;
        Coordinator coordinator = new Coordinator.Builder()
                .setCoordinatorId(coordinatorId)
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setPassword("securepassword")
                .build();

        when(coordinatorRepository.findById(coordinatorId)).thenReturn(Optional.of(coordinator));

        // Act
        Coordinator foundCoordinator = coordinatorService.read(coordinatorId);

        // Assert
        assertNotNull(foundCoordinator);
        assertEquals(coordinator, foundCoordinator);
        verify(coordinatorRepository, times(1)).findById(coordinatorId);
    }

    @Test
    void read_ShouldReturnNullWhenNotFound() {
        // Arrange
        int coordinatorId = 1;
        when(coordinatorRepository.findById(coordinatorId)).thenReturn(Optional.empty());

        // Act
        Coordinator foundCoordinator = coordinatorService.read(coordinatorId);

        // Assert
        assertNull(foundCoordinator);
        verify(coordinatorRepository, times(1)).findById(coordinatorId);
    }

    @Test
    void update_ShouldSaveAndReturnUpdatedCoordinator() {
        // Arrange
        Coordinator coordinator = new Coordinator.Builder()
                .setCoordinatorId(1)
                .setName("John Doe Updated")
                .setEmail("john.updated@example.com")
                .setPassword("newpassword123")
                .build();

        when(coordinatorRepository.save(coordinator)).thenReturn(coordinator);

        // Act
        Coordinator updatedCoordinator = coordinatorService.update(coordinator);

        // Assert
        assertNotNull(updatedCoordinator);
        assertEquals(coordinator, updatedCoordinator);
        verify(coordinatorRepository, times(1)).save(coordinator);
    }

    @Test
    void getAll_ShouldReturnListOfCoordinators() {
        // Arrange
        Coordinator coordinator1 = new Coordinator.Builder()
                .setCoordinatorId(1)
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setPassword("password123")
                .build();

        Coordinator coordinator2 = new Coordinator.Builder()
                .setCoordinatorId(2)
                .setName("Jane Doe")
                .setEmail("jane.doe@example.com")
                .setPassword("securepassword")
                .build();

        List<Coordinator> coordinators = Arrays.asList(coordinator1, coordinator2);
        when(coordinatorRepository.findAll()).thenReturn(coordinators);

        // Act
        List<Coordinator> allCoordinators = coordinatorService.getAll();

        // Assert
        assertNotNull(allCoordinators);
        assertEquals(2, allCoordinators.size());
        assertTrue(allCoordinators.contains(coordinator1));
        assertTrue(allCoordinators.contains(coordinator2));
        verify(coordinatorRepository, times(1)).findAll();

    }
}
