package za.ac.biic.factory;

import za.ac.biic.domain.Employer;

public class EmployerFactory {
    public static Employer createEmployer(int employerId, String companyName, String hrEmail, String password) {
        // Validation logic
        if (companyName == null || companyName.isEmpty()) {
            throw new IllegalArgumentException("Company name cannot be null or empty");
        }
        if (hrEmail == null || hrEmail.isEmpty() || !hrEmail.contains("@")) {
            throw new IllegalArgumentException("Invalid HR email address");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }

        // Using Builder pattern to create the Employer instance
        return new Employer.Builder()
                .setEmployerId(employerId)
                .setCompanyName(companyName)
                .setHrEmail(hrEmail)
                .setPassword(password)
                .build();
    }
}
