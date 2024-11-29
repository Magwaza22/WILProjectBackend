package za.ac.biic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.biic.domain.PlacementStatus;
import za.ac.biic.service.PlacementStatusService;

@RestController
@RequestMapping("/placementStatus")
public class PlacementStatusController {

    private final PlacementStatusService service;

    @Autowired
    PlacementStatusController(PlacementStatusService service) { this.service = service; }

    @PostMapping("/save")
    public PlacementStatus save(@RequestBody PlacementStatus placementStatus) {
        return service.create(placementStatus);
    }

    @GetMapping("/read/{id}")
    public PlacementStatus read(@PathVariable String id) {return service.read(Long.valueOf(id));
    }

}
