package za.ac.biic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.biic.domain.Document;
import za.ac.biic.service.DocumentService;

import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {

    private final DocumentService service;

    @Autowired
    DocumentController(DocumentService service) { this.service = service; }

    @PostMapping("/save")
    public Document save(@RequestBody Document document) {
        return service.create(document);
    }

    @GetMapping("/read/{id}")
    public Document read(@PathVariable String id) {return service.read(Long.valueOf(id));
    }

    @GetMapping("/getall")
    public List<Document> getAll(){return service.getall();}
}
