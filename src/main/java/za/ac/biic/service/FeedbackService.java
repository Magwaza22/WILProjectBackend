package za.ac.biic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.biic.domain.Feedback;
import za.ac.biic.repository.FeedbackRepository;

import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    FeedbackService(FeedbackRepository feedbackRepository){
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback create(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Feedback read(Integer integer) {
        return feedbackRepository.findById(integer).orElse(null);
    }

    @Override
    public Feedback update(Feedback feedback) {
       return feedbackRepository.save(feedback);
    }

    @Override
    public void delete(Integer feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }

    @Override
    public List<Feedback> getall() {
        return feedbackRepository.findAll();
    }

}
