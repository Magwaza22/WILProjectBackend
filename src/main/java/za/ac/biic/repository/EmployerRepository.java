package za.ac.biic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.biic.domain.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {
}
