package za.ac.biic.factory;

import org.junit.jupiter.api.Test;
import za.ac.biic.domain.Document;
import za.ac.biic.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

class DocumentFactoryTest {

    @Test
    void createDocument_Success() {

        Long documentID = 1L;
        String type = "Transcript";
        String file = "transcript.pdf";
        Student student = new Student.Builder()
                .setStudentID(101L)
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setPassword("password123")
                .setCourse("Software Engineering")
                .setSkills("Java, Python")
                .build();

        Document createdDocument = DocumentFactory.createDocument(documentID, type, file, student);

        assertNotNull(createdDocument);
        assertEquals(documentID, createdDocument.getDocumentID());
        assertEquals(type, createdDocument.getType());
        assertEquals(file, createdDocument.getFile());
        assertEquals(student, createdDocument.getStudent());
    }

    @Test
    void createDocument_Fail() {

        Long documentID = null;
        String type = "";
        String file = null;
        Student student = null;

        Document createdDocument = DocumentFactory.createDocument(documentID, type, file, student);

        assertNull(createdDocument, "Expected null when invalid inputs are provided");
    }
}