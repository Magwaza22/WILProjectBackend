package za.ac.biic.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.biic.domain.Employer;
import za.ac.biic.repository.EmployerRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployerServiceTest {

    @Mock
    private EmployerRepository employerRepository;

    @InjectMocks
    private EmployerService employerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create_ShouldSaveAndReturnEmployer() {
        // Arrange
        Employer employer = new Employer.Builder()
                .setEmployerId(1)
                .setCompanyName("Tech Solutions")
                .setHrEmail("hr@techsolutions.com")
                .setPassword("password123")
                .build();

        when(employerRepository.save(employer)).thenReturn(employer);

        // Act
        Employer savedEmployer = employerService.create(employer);

        // Assert
        assertNotNull(savedEmployer);
        assertEquals(employer, savedEmployer);
        verify(employerRepository, times(1)).save(employer);
    }

    @Test
    void read_ShouldReturnEmployerWhenFound() {
        // Arrange
        int employerId = 1;
        Employer employer = new Employer.Builder()
                .setEmployerId(employerId)
                .setCompanyName("Tech Solutions")
                .setHrEmail("hr@techsolutions.com")
                .setPassword("password123")
                .build();

        when(employerRepository.findById(employerId)).thenReturn(Optional.of(employer));

        // Act
        Employer foundEmployer = employerService.read(employerId);

        // Assert
        assertNotNull(foundEmployer);
        assertEquals(employer, foundEmployer);
        verify(employerRepository, times(1)).findById(employerId);
    }

    @Test
    void read_ShouldReturnNullWhenNotFound() {
        // Arrange
        int employerId = 1;
        when(employerRepository.findById(employerId)).thenReturn(Optional.empty());

        // Act
        Employer foundEmployer = employerService.read(employerId);

        // Assert
        assertNull(foundEmployer);
        verify(employerRepository, times(1)).findById(employerId);
    }

    @Test
    void update_ShouldSaveAndReturnUpdatedEmployer() {
        // Arrange
        Employer employer = new Employer.Builder()
                .setEmployerId(1)
                .setCompanyName("Tech Solutions Updated")
                .setHrEmail("hr@techsolutions.com")
                .setPassword("newpassword123")
                .build();

        when(employerRepository.save(employer)).thenReturn(employer);

        // Act
        Employer updatedEmployer = employerService.update(employer);

        // Assert
        assertNotNull(updatedEmployer);
        assertEquals(employer, updatedEmployer);
        verify(employerRepository, times(1)).save(employer);
    }

    @Test
    void getAll_ShouldReturnListOfEmployers() {
        // Arrange
        Employer employer1 = new Employer.Builder()
                .setEmployerId(1)
                .setCompanyName("Tech Solutions")
                .setHrEmail("hr@techsolutions.com")
                .setPassword("password123")
                .build();

        Employer employer2 = new Employer.Builder()
                .setEmployerId(2)
                .setCompanyName("Innovative Solutions")
                .setHrEmail("hr@innovativesolutions.com")
                .setPassword("securepassword")
                .build();

        List<Employer> employers = Arrays.asList(employer1, employer2);
        when(employerRepository.findAll()).thenReturn(employers);

        // Act
        List<Employer> allEmployers = employerService.getAll();

        // Assert
        assertNotNull(allEmployers);
        assertEquals(2, allEmployers.size());
        assertTrue(allEmployers.contains(employer1));
        assertTrue(allEmployers.contains(employer2));
        verify(employerRepository, times(1)).findAll();

    }
}
