package za.ac.biic.domain;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentID;
    private String name;
    private String email;
    private String password;
    private String course;
    private String skills;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Document> documents;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<PlacementStatus> placementStatuses;

    public Student() {

    }

    public Student (Builder builder) {
        this.studentID = builder.studentID;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.course = builder.course;
        this.skills = builder.skills;
        this.documents = builder.documents;
        this.placementStatuses = builder.placementStatuses;
    }

    public Long getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCourse() {
        return course;
    }

    public String getSkills() {
        return skills;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public List<PlacementStatus> getPlacementStatuses() {
        return placementStatuses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentID, student.studentID) && Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(password, student.password) && Objects.equals(course, student.course) && Objects.equals(skills, student.skills) && Objects.equals(documents, student.documents) && Objects.equals(placementStatuses, student.placementStatuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, name, email, password, course, skills, documents, placementStatuses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", course='" + course + '\'' +
                ", skills='" + skills + '\'' +
                ", documents=" + documents +
                ", placementStatuses=" + placementStatuses +
                '}';
    }

    public static class Builder {

        private Long studentID;
        private String name;
        private String email;
        private String password;
        private String course;
        private String skills;

        private List<Document> documents;

        private List<PlacementStatus> placementStatuses;

        public Builder setStudentID(Long studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setCourse(String course) {
            this.course = course;
            return this;
        }

        public Builder setSkills(String skills) {
            this.skills = skills;
            return this;
        }

        public Builder setDocuments(List<Document> documents) {
            this.documents = documents;
            return this;
        }

        public Builder setPlacementStatuses(List<PlacementStatus> placementStatuses) {
            this.placementStatuses = placementStatuses;
            return this;
        }
        public Builder copy(Student s) {
            this.studentID = s.studentID;
            this.name = s.name;
            this.email = s.email;
            this.password = s.password;
            this.course = s.course;
            this.skills = s.skills;
            this.documents = s.documents;
            this.placementStatuses = s.placementStatuses;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
