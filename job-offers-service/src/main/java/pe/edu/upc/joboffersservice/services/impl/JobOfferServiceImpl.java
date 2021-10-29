package pe.edu.upc.joboffersservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.joboffersservice.client.EmployeerClient;
import pe.edu.upc.joboffersservice.entities.Employeer;
import pe.edu.upc.joboffersservice.entities.JobOffer;
import pe.edu.upc.joboffersservice.repositories.JobOfferRepository;
import pe.edu.upc.joboffersservice.services.JobOfferService;

import java.util.List;
import java.util.Optional;

@Service
public class JobOfferServiceImpl implements JobOfferService {
    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private EmployeerClient employeerClient;

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
    public JobOffer update(Long id, JobOffer jobOffer) throws Exception {
        jobOffer.setId(id);
        return jobOfferRepository.save(jobOffer);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        jobOfferRepository.deleteById(id);
    }

    @Override
    public JobOffer createJobOfferByEmployeerId(Long employeerId, JobOffer jobOffer) {
        JobOffer jobOfferNew;
        if(null != employeerClient.getEmployeer(employeerId).getBody()){
            System.out.println(employeerClient.getEmployeer(employeerId).getBody());
            jobOffer.setEmployeerId(employeerId);
            jobOfferNew = jobOfferRepository.save(jobOffer);
            Employeer employeer = employeerClient.getEmployeer(employeerId).getBody();
            jobOfferNew.setEmployeer(employeer);
            return jobOfferNew;
        }else{
            jobOfferNew = new JobOffer();
            jobOfferNew.setEmployeerId(0L);
            return jobOfferNew;
        }
    }

    @Override
    public List<JobOffer> findByEmployeerId(Long employerId) throws Exception {
        return jobOfferRepository.findJobOfferByEmployeerId(employerId);
    }
}
