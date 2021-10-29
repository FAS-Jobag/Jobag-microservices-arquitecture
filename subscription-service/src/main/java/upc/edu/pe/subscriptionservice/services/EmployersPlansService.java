package upc.edu.pe.subscriptionservice.services;

import org.springframework.stereotype.Service;

import upc.edu.pe.subscriptionservice.entities.EmployersPlans;
import upc.edu.pe.subscriptionservice.entities.PostulantsPlans;

/**
* EmployersPlansService
*/
@Service
public interface EmployersPlansService extends CrudServices<EmployersPlans, Long> {
    EmployersPlans assignSubscriptionToEmployer(Long subscriptionId, Long employerId);
    void unassignSubscriptionToEmployer(Long subscriptionId, Long employerId);
    EmployersPlans getPlanByEmployerId(Long employerId);
}
