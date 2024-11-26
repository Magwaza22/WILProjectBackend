package za.ac.biic.domain;

import jakarta.persistence.*;
import za.ac.biic.domain.Student;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentID;
    private String type;
    private String file;

    @ManyToOne
    @JoinColumn(name = "studentID")
    private Student student;

    public Document() {
    }
}
