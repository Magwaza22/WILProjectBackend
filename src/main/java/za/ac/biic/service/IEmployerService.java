package za.ac.biic.service;

import za.ac.biic.domain.Employer;

import java.util.List;

public interface IEmployerService {

    Employer create(Employer employer);

    Employer read(int employerId);

    Employer update(Employer employer);

    List<Employer> getAll();
}
