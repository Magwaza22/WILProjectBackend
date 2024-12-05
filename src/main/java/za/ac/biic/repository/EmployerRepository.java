package za.ac.biic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.biic.domain.Employer;
@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {
}
