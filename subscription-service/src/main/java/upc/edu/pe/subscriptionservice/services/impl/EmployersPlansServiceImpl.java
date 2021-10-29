package upc.edu.pe.subscriptionservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.subscriptionservice.client.EmployerClient;
import upc.edu.pe.subscriptionservice.entities.EmployersPlans;
import upc.edu.pe.subscriptionservice.entities.PlanEmployer;
import upc.edu.pe.subscriptionservice.entities.PlanPostulant;
import upc.edu.pe.subscriptionservice.entities.PostulantsPlans;
import upc.edu.pe.subscriptionservice.models.Employer;
import upc.edu.pe.subscriptionservice.models.Postulant;
import upc.edu.pe.subscriptionservice.repositories.EmployersPlansRepository;
import upc.edu.pe.subscriptionservice.repositories.PlansEmployerRepository;
import upc.edu.pe.subscriptionservice.services.EmployersPlansService;
import upc.edu.pe.subscriptionservice.services.PlansEmployerService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployersPlansServiceImpl implements EmployersPlansService {
    @Autowired
    private EmployersPlansRepository employersPlansRepository;

    @Autowired
    private PlansEmployerRepository plansEmployerRepository;

    @Autowired
    private EmployerClient employerClient;

    @Override
    public EmployersPlans save(EmployersPlans entity) throws Exception {
        return employersPlansRepository.save(entity);
    }

    @Override
    public List<EmployersPlans> findAll() throws Exception {
        return employersPlansRepository.findAll();
    }

    @Override
    public Optional<EmployersPlans> findById(Long aLong) throws Exception {
        return employersPlansRepository.findById(aLong);
    }

    @Override
    public EmployersPlans update(EmployersPlans entity) throws Exception {
        return employersPlansRepository.save(entity);
    }

    @Override
    public void deleteById(Long aLong) throws Exception {
        employersPlansRepository.deleteById(aLong);
    }


    @Override
    public EmployersPlans assignSubscriptionToEmployer(Long subscriptionId, Long employerId) {
        if (employersPlansRepository.findByEmployerId(employerId) != null) return null;

        return plansEmployerRepository.findById(subscriptionId).map(plan -> {
            EmployersPlans employersPlans = new EmployersPlans();
            employersPlans.setPlansEmployer(plan);
            employersPlans.setEmployerId(employerId);
            return employersPlansRepository.save(employersPlans);
        }).orElse(null);
    }

    @Override
    public void unassignSubscriptionToEmployer(Long subscriptionId, Long employerId) {
        PlanEmployer plan = plansEmployerRepository.findById(subscriptionId).orElse(null);
        if (plan != null) {
            EmployersPlans employersPlans = employersPlansRepository.findByEmployerId(employerId);
            employersPlansRepository.delete(employersPlans);
        }
    }

    @Override
    public EmployersPlans getPlanByEmployerId(Long employerId) {
        EmployersPlans plan = employersPlansRepository.findByEmployerId(employerId);
        ResponseEntity<Employer> employer = employerClient.getEmployer(plan.getEmployerId());
        plan.setEmployer(employer.getBody());
        return  plan;
    }
}