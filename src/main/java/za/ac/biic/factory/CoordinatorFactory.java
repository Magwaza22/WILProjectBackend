package za.ac.biic.factory;

import za.ac.biic.domain.Coordinator;

public class CoordinatorFactory {
    public static Coordinator createCoordinator(int coordinatorId, String name, String email, String password) {
        // Validation logic can be added here
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }

        return new Coordinator.Builder()
                .setCoordinatorId(coordinatorId)
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .build();
    }
}
