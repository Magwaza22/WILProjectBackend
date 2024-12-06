package za.ac.biic.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.biic.domain.Coordinator;
import za.ac.biic.factory.CoordinatorFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class CoordinatorServiceTest {

    @Autowired
    private CoordinatorService coordinatorService;

    private static Coordinator coordinator1, coordinator2, coordinator3;

    @BeforeEach
    void setUp() {
        coordinator1 = CoordinatorFactory.createCoordinator(1, "Alice Johnson", "alice.johnson@example.com", "password123");
        assertNotNull(coordinator1);
        System.out.println(coordinator1);

        coordinator2 = CoordinatorFactory.createCoordinator(2, "Bob Smith", "bob.smith@example.com", "securepassword");
        assertNotNull(coordinator2);
        System.out.println(coordinator2);

        coordinator3 = CoordinatorFactory.createCoordinator(3, "Cathy Lee", "cathy.lee@example.com", "mypassword");
        assertNotNull(coordinator3);
        System.out.println(coordinator3);
    }

    @Test
    void create() {
        Coordinator created1 = coordinatorService.create(coordinator1);
        assertNotNull(created1);
        System.out.println(created1);

        Coordinator created2 = coordinatorService.create(coordinator2);
        assertNotNull(created2);
        System.out.println(created2);

        Coordinator created3 = coordinatorService.create(coordinator3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void read() {
        assert coordinator1 != null;
        Coordinator read = coordinatorService.read(coordinator1.getCoordinatorId());
        System.out.println(read);
    }

    @Test
    void update() {
        Coordinator updatedCoordinator = new Coordinator.Builder()
                .copy(coordinator2)
                .setName("Robert Smith")
                .build();
        Coordinator updated = coordinatorService.update(updatedCoordinator);
        assertNotNull(updated);
        System.out.println(updated);
    }
    

    @Test
    void getall() {
        System.out.println(coordinatorService.getAll());
    }
}
