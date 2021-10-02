package pe.edu.upc.joboffersservice.services;

import pe.edu.upc.joboffersservice.entities.Interview;
import pe.edu.upc.joboffersservice.services.common.CrudService;

import java.util.List;

public interface InterviewService extends CrudService<Interview, Long> {
    List<Interview> findByJobOfferId(Long offerId) throws Exception;
    Interview saveByJobOfferId(Long jobOfferId, Interview interview) throws Exception;

}