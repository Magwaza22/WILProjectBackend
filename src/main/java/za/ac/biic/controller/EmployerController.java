package za.ac.biic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.biic.domain.Employer;
import za.ac.biic.service.EmployerService;

import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {

    private final EmployerService service;

    @Autowired
    EmployerController(EmployerService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public Employer save(@RequestBody Employer employer) {
        return service.create(employer);
    }

    @GetMapping("/read/{id}")
    public Employer read(@PathVariable int id) {
        return service.read(id);
    }

    @GetMapping("/getall")
    public List<Employer> getAll() {
        return service.getAll();
    }
}
