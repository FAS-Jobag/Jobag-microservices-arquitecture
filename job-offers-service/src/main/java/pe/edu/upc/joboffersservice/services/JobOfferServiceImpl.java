package pe.edu.upc.joboffersservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.joboffersservice.entities.JobOffer;
import pe.edu.upc.joboffersservice.repositories.JobOfferRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobOfferServiceImpl implements JobOfferService {
    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Override
    public JobOffer save(JobOffer jobOffer) throws Exception {
        return jobOfferRepository.save(jobOffer);
    }

    @Override
    public List<JobOffer> findAll() throws Exception {
        return jobOfferRepository.findAll();
    }

    @Override
    public Optional<JobOffer> findById(Long id) throws Exception {
        return jobOfferRepository.findById(id);
    }

    @Override
    public JobOffer update(JobOffer jobOffer) throws Exception {
        return jobOfferRepository.save(jobOffer);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        jobOfferRepository.deleteById(id);
    }
}
