package za.ac.biic.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coordinatorId ;
    private String name;
    private String email;
    private String password;

    public Coordinator() {}

    public Coordinator(Builder builder) {
        this.coordinatorId = builder.coordinatorId;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
    }

    public int getCoordinatorId() {
        return coordinatorId;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinator that = (Coordinator) o;
        return coordinatorId == that.coordinatorId && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinatorId, name, email, password);
    }

    @Override
    public String toString() {
        return "Coordinator{" +
                "coordinatorId=" + coordinatorId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public static class Builder {
        private int coordinatorId;
        private String name;
        private String email;
        private String password;

        public Builder setCoordinatorId(int coordinatorId) {
            this.coordinatorId = coordinatorId;
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
        public Coordinator build() {return new Coordinator(this);}
    }
}
