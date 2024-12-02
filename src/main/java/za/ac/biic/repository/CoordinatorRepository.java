package za.ac.biic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.biic.domain.Coordinator;

public interface CoordinatorRepository extends JpaRepository<Coordinator, Integer> {
}
