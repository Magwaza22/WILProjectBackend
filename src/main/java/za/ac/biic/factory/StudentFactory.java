package za.ac.biic.factory;

import za.ac.biic.domain.Student;
import za.ac.biic.util.Helper;

public class StudentFactory {

        public static Student createStudent(Long studentID, String name, String email, String password, String course, String skills) {
            if (Helper.isNullOrEmpty(String.valueOf(studentID)) || Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(email)
                    || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(course) || Helper.isNullOrEmpty(skills)) {
                return null;
            }

            return new Student.Builder().setStudentID(studentID)
                    .setName(name)
                    .setEmail(email)
                    .setPassword(password)
                    .setCourse(course)
                    .setSkills(skills)
                    .build();
        }

}
