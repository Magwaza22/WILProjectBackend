package za.ac.biic.factory;

import za.ac.biic.domain.Student;
import za.ac.biic.util.Helper;
import za.ac.biic.domain.Document;

public class DocumentFactory {

    public static Document createDocument(Long documentID, String type, String file, Student studentID) {
        if (Helper.isNullOrEmpty(String.valueOf(documentID)) || Helper.isNullOrEmpty(type)
                || Helper.isNullOrEmpty(file) || Helper.isNullOrEmpty(String.valueOf(studentID))) {
            return null;
        }

        return new Document.Builder().setDocumentID(documentID)
                .setType(type)
                .setFile(file)
                .setStudent(studentID)
                .build();
    }
}
