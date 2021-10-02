package pe.edu.upc.joboffersservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.joboffersservice.entities.Interview;
import pe.edu.upc.joboffersservice.entities.JobOffer;
import pe.edu.upc.joboffersservice.repositories.InterviewRepository;
import pe.edu.upc.joboffersservice.repositories.JobOfferRepository;
import pe.edu.upc.joboffersservice.services.InterviewService;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Override
    public Interview save(Interview interview) throws Exception {
        return interviewRepository.save(interview);
    }

    @Override
    public List<Interview> findAll() throws Exception {
        return interviewRepository.findAll();
    }

    @Override
    public Optional<Interview> findById(Long id) throws Exception {
        return interviewRepository.findById(id);
    }

    @Override
    public Interview update(Long id, Interview interview) throws Exception {
        interview.setId(id);
        return interviewRepository.save(interview);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        interviewRepository.deleteById(id);
    }

    @Override
    public List<Interview> findByJobOfferId(Long offerId) throws Exception {
        return jobOfferRepository.findById(offerId)
                .map(JobOffer::getInterviews)
                .orElseThrow();
    }

    @Override
    public Interview saveByJobOfferId(Long jobOfferId, Interview interview) throws Exception {
        return jobOfferRepository.findById(jobOfferId).map(jobOffer -> {
            interview.setJobOffer(jobOffer);
            return interviewRepository.save(interview);
        }).orElseThrow();
    }
}
