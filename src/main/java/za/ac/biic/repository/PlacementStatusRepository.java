package za.ac.biic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.biic.domain.PlacementStatus;

@Repository
public interface PlacementStatusRepository extends JpaRepository<PlacementStatus, Long> {
}
