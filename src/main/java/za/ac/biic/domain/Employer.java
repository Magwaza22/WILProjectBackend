package za.ac.biic.domain;

import java.util.Objects;

public class Employer {
    private int employerId;
    private String companyName;
    private String hrEmail;
    private String password;

    public Employer() {
    }

    public Employer(Builder builder) {
        this.employerId = builder.employerId;
        this.companyName = builder.companyName;
        this.hrEmail = builder.hrEmail;
        this.password = builder.password;
    }

    public int getEmployerId() {
        return employerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getHrEmail() {
        return hrEmail;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return employerId == employer.employerId && Objects.equals(companyName, employer.companyName) && Objects.equals(hrEmail, employer.hrEmail) && Objects.equals(password, employer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employerId, companyName, hrEmail, password);
    }

    @Override
    public String toString() {
        return "Employer{" +
                "employerId=" + employerId +
                ", companyName='" + companyName + '\'' +
                ", hrEmail='" + hrEmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {
        private int employerId;
        private String companyName;
        private String hrEmail;
        private String password;


        public Builder setEmployerId(int employerId) {
            this.employerId = employerId;
            return this;
        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder setHrEmail(String hrEmail) {
            this.hrEmail = hrEmail;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(Employer employer) {
            this.employerId = employer.employerId;
            this.companyName = employer.companyName;
            this.hrEmail = employer.hrEmail;
            this.password = employer.password;
            return this;
        }

        public Employer build() {
            return new Employer(this);
        }
    }
}