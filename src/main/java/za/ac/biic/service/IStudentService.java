package za.ac.biic.service;

import za.ac.biic.domain.Student;
import java.util.List;

public interface IStudentService extends IService<Student, Long>{

    void delete(Long studentId);
    List<Student> getall();
}
