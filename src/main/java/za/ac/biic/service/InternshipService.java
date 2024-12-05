package za.ac.biic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.biic.domain.Internship;
import za.ac.biic.repository.InternshipRepository;

import java.util.List;

@Service
public class InternshipService implements IInternshipService {

    private final InternshipRepository internshipRepository;

    @Autowired
    InternshipService(InternshipRepository internshipRepository) {
        this.internshipRepository = internshipRepository;
    }

    @Override
    public Internship create(Internship internship) {
        return internshipRepository.save(internship);
    }

    @Override
    public Internship read(Long aLong) {
        return internshipRepository.findById(aLong).orElse(null);
    }

    @Override
    public Internship update(Internship internship) {
        return internshipRepository.save(internship);
    }

    @Override
    public void delete(Long internshipId) {
        internshipRepository.deleteById(internshipId);
    }

    @Override
    public List<Internship> getall() {
        return internshipRepository.findAll();
    }
}
