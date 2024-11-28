package za.ac.biic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.biic.domain.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
