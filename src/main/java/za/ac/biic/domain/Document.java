package za.ac.biic.domain;

import jakarta.persistence.*;

import java.util.Objects;

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

    public Document (Builder builder) {
        this.documentID = builder.documentID;
        this.type = builder.type;
        this.file = builder.file;
        this.student = builder.student;
    }

    public Long getDocumentID() {
        return documentID;
    }

    public String getType() {
        return type;
    }

    public String getFile() {
        return file;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(documentID, document.documentID) && Objects.equals(type, document.type) && Objects.equals(file, document.file) && Objects.equals(student, document.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentID, type, file, student);
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentID=" + documentID +
                ", type='" + type + '\'' +
                ", file='" + file + '\'' +
                ", student=" + student +
                '}';
    }

    public static class Builder {
        private Long documentID;
        private String type;
        private String file;
        private Student student;

        public Builder setDocumentID(Long documentID) {
            this.documentID = documentID;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setFile(String file) {
            this.file = file;
            return this;
        }

        public Builder setStudent(Student student) {
            this.student = student;
            return this;
        }

        public Document.Builder copy(Document d) {
            this.documentID = d.documentID;
            this.type = d.type;
            this.file = d.file;
            this.student = d.student;
            return this;
        }
        public Document build() {
            return new Document(this);
        }
    }
}
