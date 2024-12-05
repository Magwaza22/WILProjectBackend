package za.ac.biic.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.biic.domain.Employer;
import za.ac.biic.factory.EmployerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployerServiceTest {

    @Autowired
    private EmployerService employerService;

    private static Employer employer1, employer2, employer3;

    @BeforeEach
    void setUp() {
        employer1 = EmployerFactory.createEmployer(1, "Tech Corp", "hr@techcorp.com", "securepassword");
        assertNotNull(employer1);
        System.out.println(employer1);

        employer2 = EmployerFactory.createEmployer(2, "Innova Inc", "hr@innovainc.com", "password123");
        assertNotNull(employer2);
        System.out.println(employer2);

        employer3 = EmployerFactory.createEmployer(3, "Global Solutions", "hr@globalsolutions.com", "globalpass");
        assertNotNull(employer3);
        System.out.println(employer3);
    }

    @Test
    void create() {
        Employer created1 = employerService.create(employer1);
        assertNotNull(created1);
        System.out.println(created1);

        Employer created2 = employerService.create(employer2);
        assertNotNull(created2);
        System.out.println(created2);

        Employer created3 = employerService.create(employer3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void read() {
        assert employer1 != null;
        Employer read = employerService.read(employer1.getEmployerId());
        System.out.println(read);
    }

    @Test
    void update() {
        Employer updatedEmployer = new Employer.Builder()
                .copy(employer2)
                .setCompanyName("Innova International")
                .build();
        Employer updated = employerService.update(updatedEmployer);
        assertNotNull(updated);
        System.out.println(updated);
    }


    @Test
    void getall() {
        System.out.println(employerService.getAll());
    }
}
