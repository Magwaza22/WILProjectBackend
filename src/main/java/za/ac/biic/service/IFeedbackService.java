package za.ac.biic.service;

import za.ac.biic.domain.Feedback;

import java.util.List;

public interface IFeedbackService extends IService<Feedback, Integer>{

    void delete(Integer feedbackId);
    List<Feedback> getall();
}
