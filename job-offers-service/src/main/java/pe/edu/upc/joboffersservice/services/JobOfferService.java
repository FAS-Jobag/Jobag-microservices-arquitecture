package pe.edu.upc.joboffersservice.services;

import pe.edu.upc.joboffersservice.entities.Interview;
import pe.edu.upc.joboffersservice.entities.JobOffer;
import pe.edu.upc.joboffersservice.services.common.CrudService;

import java.util.List;

public interface JobOfferService extends CrudService<JobOffer, Long> {

    JobOffer createJobOfferByEmployeerId(Long employeerId, JobOffer jobOffer);
    List<JobOffer> findByEmployeerId(Long employerId) throws Exception;
}
