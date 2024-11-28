package za.ac.biic.service;

import za.ac.biic.domain.Document;
import za.ac.biic.domain.Student;

import java.util.List;

public interface IDocumentService extends IService<Document, Long>{
    List<Document> getall();
}
