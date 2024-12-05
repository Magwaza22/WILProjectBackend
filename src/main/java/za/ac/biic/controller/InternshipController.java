package za.ac.biic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.biic.domain.Internship;
import za.ac.biic.service.InternshipService;

import java.util.List;

@RestController
@RequestMapping("/internship")
public class InternshipController {

    private final InternshipService service;

    @Autowired
    InternshipController(InternshipService service) { this.service = service; }

    @PostMapping("/save")
    public Internship save(@RequestBody Internship internship) {
        return service.create(internship);
    }

    @GetMapping("/read/{id}")
    public Internship read(@PathVariable String id) {return service.read(Long.valueOf(id));
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteByID(@PathVariable String id){service.delete(Long.valueOf(id));}

    @GetMapping("/getall")
    public List<Internship> getAll(){return service.getall();}
}
