package za.ac.biic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.biic.domain.Feedback;
import za.ac.biic.service.FeedbackService;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackService service;

    @Autowired
    FeedbackController(FeedbackService service) { this.service = service; }

    @PostMapping("/save")
    public Feedback save(@RequestBody Feedback feedback) {
        return service.create(feedback);
    }

    @GetMapping("/read/{id}")
    public Feedback read(@PathVariable String id) {return service.read(Integer.valueOf(id));
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteByID(@PathVariable String id){service.delete(Integer.valueOf(id));}

    @GetMapping("/getall")
    public List<Feedback> getAll(){return service.getall();}
}
