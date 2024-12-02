package za.ac.biic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.biic.domain.Employer;
import za.ac.biic.repository.EmployerRepository;

import java.util.List;

@Service
public class EmployerService implements IEmployerService {

    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public Employer create(Employer employer) {
        return employerRepository.save(employer);
    }

    @Override
    public Employer read(int employerId) {
        return employerRepository.findById(employerId).orElse(null);
    }

    @Override
    public Employer update(Employer employer) {
        return employerRepository.save(employer);
    }

    @Override
    public List<Employer> getAll() {
        return employerRepository.findAll();
    }
}
