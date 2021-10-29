package upc.edu.pe.subscriptionservice.services;

import org.springframework.stereotype.Service;

import upc.edu.pe.subscriptionservice.entities.PostulantsPlans;

/**
* PostulantsPlansService
*/
@Service
public interface PostulantsPlansService extends CrudServices<PostulantsPlans, Long> {
    PostulantsPlans assignSubscriptionToPostulant(Long subscriptionId, Long postulantId);
    void unassignSubscriptionToPostulant(Long subscriptionId, Long postulantId);
    PostulantsPlans getPlanByPostulantId(Long postulantId);
}
