package za.ac.biic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.biic.domain.Coordinator;
import za.ac.biic.repository.CoordinatorRepository;

import java.util.List;

@Service
public class CoordinatorService implements ICoordinatorService {

    private final CoordinatorRepository coordinatorRepository;

    @Autowired
    public CoordinatorService(CoordinatorRepository coordinatorRepository) {
        this.coordinatorRepository = coordinatorRepository;
    }

    @Override
    public Coordinator create(Coordinator coordinator) {
        return coordinatorRepository.save(coordinator);
    }

    @Override
    public Coordinator read(int coordinatorId) {
        return coordinatorRepository.findById(coordinatorId).orElse(null);
    }

    @Override
    public Coordinator update(Coordinator coordinator) {
        return coordinatorRepository.save(coordinator);
    }

    @Override
    public List<Coordinator> getAll() {
        return coordinatorRepository.findAll();
    }
}
