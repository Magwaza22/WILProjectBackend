package za.ac.biic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.biic.domain.PlacementStatus;
import za.ac.biic.repository.PlacementStatusRepository;

@Service
public class PlacementStatusService implements IPlacementStatusService {

    private final PlacementStatusRepository placementStatusRepository;

    @Autowired
    PlacementStatusService(PlacementStatusRepository placementStatusRepository){
        this.placementStatusRepository = placementStatusRepository;
    }

    @Override
    public PlacementStatus create(PlacementStatus placementStatus) {
        return placementStatusRepository.save(placementStatus);
    }

    @Override
    public PlacementStatus read(Long aLong) {
        return placementStatusRepository.findById(aLong).orElse(null);
    }

    @Override
    public PlacementStatus update(PlacementStatus placementStatus) {
        return placementStatusRepository.save(placementStatus);
    }
}
