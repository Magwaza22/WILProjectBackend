package za.ac.biic.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class PlacementStatus {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long statusID;
        private String status;
        private String details;

        @ManyToOne
        @JoinColumn(name = "studentID")
        private Student student;

        public PlacementStatus() {
        }

        public PlacementStatus (Builder builder) {
                this.statusID = builder.statusID;
                this.status = builder.status;
                this.details = builder.details;
                this.student = builder.student;
        }

        public Long getStatusID() {
                return statusID;
        }

        public String getStatus() {
                return status;
        }

        public String getDetails() {
                return details;
        }

        public Student getStudent() {
                return student;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                PlacementStatus that = (PlacementStatus) o;
                return Objects.equals(statusID, that.statusID) && Objects.equals(status, that.status) && Objects.equals(details, that.details) && Objects.equals(student, that.student);
        }

        @Override
        public int hashCode() {
                return Objects.hash(statusID, status, details, student);
        }

        @Override
        public String toString() {
                return "PlacementStatus{" +
                        "statusID=" + statusID +
                        ", status='" + status + '\'' +
                        ", details='" + details + '\'' +
                        ", student=" + student +
                        '}';
        }

        public static class Builder {
                private Long statusID;
                private String status;
                private String details;
                private Student student;

                public Builder setStatusID(Long statusID) {
                        this.statusID = statusID;
                        return this;
                }

                public Builder setStatus(String status) {
                        this.status = status;
                        return this;
                }

                public Builder setDetails(String details) {
                        this.details = details;
                        return this;
                }

                public Builder setStudent(Student student) {
                        this.student = student;
                        return this;
                }

                public PlacementStatus.Builder copy(PlacementStatus Ps) {
                        this.statusID = Ps.statusID;
                        this.status = Ps.status;
                        this.details = Ps.details;
                        this.student = Ps.student;
                        return this;
                }

                public PlacementStatus build() {
                        return new PlacementStatus(this);
                }
        }
}


