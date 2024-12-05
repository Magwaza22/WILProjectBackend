package za.ac.biic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.biic.domain.Coordinator;
import za.ac.biic.service.CoordinatorService;

import java.util.List;

@RestController
@RequestMapping("/coordinator")
public class CoordinatorController {

    private final CoordinatorService service;

    @Autowired
    CoordinatorController(CoordinatorService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Coordinator save(@RequestBody Coordinator coordinator) {
        return service.create(coordinator);
    }

    @GetMapping("/read/{id}")
    public Coordinator read(@PathVariable int id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    public List<Coordinator> getAll() {
        return service.getAll();
    }

    @PutMapping("/update")
    public Coordinator update(@RequestBody Coordinator coordinator) {
        return service.update(coordinator);
    }
}
