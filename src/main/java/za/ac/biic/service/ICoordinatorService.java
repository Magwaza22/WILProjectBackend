package za.ac.biic.service;

import za.ac.biic.domain.Coordinator;

import java.util.List;

public interface ICoordinatorService {

    Coordinator create(Coordinator coordinator);

    Coordinator read(int coordinatorId);

    Coordinator update(Coordinator coordinator);

    List<Coordinator> getAll();
}
