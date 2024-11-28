package za.ac.biic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.biic.domain.Student;
import za.ac.biic.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;

    @Autowired
    StudentController(StudentService service) { this.service = service; }

    @PostMapping("/save")
    public Student save(@RequestBody Student student) {
        return service.create(student);
    }

    @GetMapping("/read/{id}")
    public Student read(@PathVariable String id) {return service.read(Long.valueOf(id));
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteByID(@PathVariable String id){service.delete(Long.valueOf(id));}

    @GetMapping("/getall")
    public List<Student> getAll(){return service.getall();}

}
