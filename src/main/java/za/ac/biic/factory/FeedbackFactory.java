package za.ac.biic.factory;

import za.ac.biic.domain.Feedback;
import za.ac.biic.domain.Student;
import za.ac.biic.util.Helper;

public class FeedbackFactory {
    public static Feedback createFeedback (int feedbackID, String comments, String status, Student studentID){
        if (Helper.isNullOrEmpty(String.valueOf(feedbackID)) || Helper.isNullOrEmpty(comments) || Helper.isNullOrEmpty(status)
            || Helper.isNullOrEmpty(String.valueOf(studentID)) ){
            return null;
        }

        return new Feedback.Builder().setFeedbackID(feedbackID)
                .setComments(comments)
                .setStatus(status)
                .setStudent(studentID)
                .build();
    }
}
