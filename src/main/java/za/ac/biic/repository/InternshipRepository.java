package za.ac.biic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.biic.domain.Internship;

@Repository
public interface InternshipRepository extends JpaRepository<Internship, Long> {
}
