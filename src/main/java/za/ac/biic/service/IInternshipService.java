package za.ac.biic.service;

import za.ac.biic.domain.Internship;

import java.util.List;

public interface IInternshipService extends IService<Internship, Long>{

    void delete(Long internshipId);
    List<Internship> getall();
}
