package za.ac.biic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.biic.domain.Document;
import za.ac.biic.repository.DocumentRepository;
import java.util.List;

@Service
public class DocumentService implements IDocumentService{

    private final DocumentRepository documentRepository;

    @Autowired
    DocumentService(DocumentRepository documentRepository){
        this.documentRepository = documentRepository;
    }

    @Override
    public Document create(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document read(Long aLong) {
        return documentRepository.findById(aLong).orElse(null);
    }

    @Override
    public Document update(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public List<Document> getall() {
        return documentRepository.findAll();
    }

}
