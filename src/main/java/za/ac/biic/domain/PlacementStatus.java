package za.ac.biic.domain;

import jakarta.persistence.*;

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

        // Getters and Setters
}


