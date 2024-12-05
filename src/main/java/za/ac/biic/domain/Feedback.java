package za.ac.biic.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;
import java.util.List;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackID;
    private String comments;
    private String status;

    @ManyToOne
    @JoinColumn(name = "studentID")
    private Student student;


    public Feedback() {
    }

    public Feedback(Builder builder) {
        this.feedbackID = builder.feedbackID;
        this.comments = builder.comments;
        this.status = builder.status;
        this.student = builder.student;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public String getComments() {
        return comments;
    }

    public String getStatus() {
        return status;
    }

    public Student getStudent() {
        return student;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return feedbackID == feedback.feedbackID && Objects.equals(comments, feedback.comments) && Objects.equals(status, feedback.status) && Objects.equals(student, feedback.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackID, comments, status, student);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackID=" + feedbackID +
                ", comments='" + comments + '\'' +
                ", status='" + status + '\'' +
                ", student=" + student +
                '}';
    }

    public static class Builder {
        private int feedbackID;
        private String comments;
        private String status;
        private Student student;

        public Builder setFeedbackID(int feedbackID) {
            this.feedbackID = feedbackID;
            return this;
        }

        public Builder setComments(String comments) {
            this.comments = comments;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setStudent(Student student) {
            this.student = student;
            return this;
        }


        public Feedback.Builder copy(Feedback feedback) {
            this.feedbackID = feedback.feedbackID;
            this.comments = feedback.comments;
            this.status = feedback.status;
            this.student = feedback.student;
            return this;
        }

        public Feedback build() {
            return new Feedback(this);
        }

    }
}