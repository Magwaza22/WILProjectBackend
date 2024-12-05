package za.ac.biic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.biic.domain.Coordinator;

@Repository
public interface CoordinatorRepository extends JpaRepository<Coordinator, Integer> {
}
