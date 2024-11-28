package za.ac.biic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.biic.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
