package za.ac.biic.factory;

import za.ac.biic.domain.Internship;
import za.ac.biic.util.Helper;

public class InternshipFactory {
    public static Internship createInternship (Long internshipID, String position, String requirements){
        if (Helper.isNullOrEmpty(String.valueOf(internshipID)) || Helper.isNullOrEmpty(position) || Helper.isNullOrEmpty(requirements)){
            return null;
        }

        return new Internship.Builder().setInternshipID(internshipID)
                .setPosition(position)
                .setRequirements(requirements)
                .build();
    }
}
