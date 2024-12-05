package za.ac.biic.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long internshipID;
    private String position;
    private String requirements;

    @OneToMany(mappedBy = "internship", cascade = CascadeType.ALL)
    private List<Feedback> feedback;

    public Internship() {

    }

    public Internship(Builder builder) {
        this.internshipID = builder.internshipID;
        this.position = builder.position;
        this.requirements = builder.requirements;
        this.feedback = builder.feedback;
    }

    public Long getInternshipID() {
        return internshipID;
    }

    public String getPosition() {
        return position;
    }

    public String getRequirements() {
        return requirements;
    }

    public List<Feedback> getFeedback() {
        return feedback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Internship that = (Internship) o;
        return Objects.equals(internshipID, that.internshipID) && Objects.equals(position, that.position) && Objects.equals(requirements, that.requirements) && Objects.equals(feedback, that.feedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internshipID, position, requirements, feedback);
    }

    @Override
    public String toString() {
        return "Internship{" +
                "internshipID=" + internshipID +
                ", position='" + position + '\'' +
                ", requirements='" + requirements + '\'' +
                ", feedback=" + feedback +
                '}';
    }

    public static class Builder {
        private Long internshipID;
        private String position;
        private String requirements;
        private Employer employer;
        private List<Feedback> feedback;

        public Builder setInternshipID(Long internshipID) {
            this.internshipID = internshipID;
            return this;
        }

        public Builder setPosition(String position) {
            this.position = position;
            return this;
        }

        public Builder setRequirements(String requirements) {
            this.requirements = requirements;
            return this;
        }

        public Builder setEmployer(Employer employer) {
            this.employer = employer;
            return this;
        }

        public Builder setFeedback(List<Feedback> feedback) {
            this.feedback = feedback;
            return this;
        }

        public Internship.Builder copy(Internship I) {
            this.internshipID = I.internshipID;
            this.position = I.position;
            this.requirements = I.requirements;
            this.feedback = I.feedback;
            return this;
        }

        public Internship build() {
            return new Internship(this);
        }
    }
}
