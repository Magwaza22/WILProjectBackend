package za.ac.biic.factory;

import za.ac.biic.domain.PlacementStatus;
import za.ac.biic.domain.Student;
import za.ac.biic.util.Helper;

public class PlacementStatusFactory {

    public static PlacementStatus createPlacementStatus(Long statusID, Student studentID, String status, String details) {
        if (Helper.isNullOrEmpty(String.valueOf(statusID)) || Helper.isNullOrEmpty(String.valueOf(studentID))
                || Helper.isNullOrEmpty(status) || Helper.isNullOrEmpty(details)) {
            return null;
        }

        return new PlacementStatus.Builder().setStatusID(statusID)
                .setStudent(studentID)
                .setStatus(status)
                .setDetails(details)
                .build();
    }
}
