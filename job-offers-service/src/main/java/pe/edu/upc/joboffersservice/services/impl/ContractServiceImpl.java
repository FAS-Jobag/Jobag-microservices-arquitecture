package pe.edu.upc.joboffersservice.services.impl;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.joboffersservice.entities.Contract;
import pe.edu.upc.joboffersservice.entities.JobOffer;
import pe.edu.upc.joboffersservice.repositories.ContractRepository;
import pe.edu.upc.joboffersservice.repositories.JobOfferRepository;
import pe.edu.upc.joboffersservice.services.ContractService;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Override
    public Contract save(Contract contract) throws Exception {
        return contractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() throws Exception {
        return contractRepository.findAll();
    }

    @Override
    public Optional<Contract> findById(Long id) throws Exception {
        return contractRepository.findById(id);
    }

    @Override
    public Contract update(Long id, Contract contract) throws Exception {
        contract.setId(id);
        return contractRepository.save(contract);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        contractRepository.deleteById(id);
    }

    @Override
    public List<Contract> findByJobOfferId(Long offerId) throws Exception {
        return jobOfferRepository.findById(offerId)
                .map(JobOffer::getContracts)
                .orElseThrow();
    }

    @Override
    public Contract saveByJobOfferId(Long jobOfferId, Contract contract) throws Exception {
        return jobOfferRepository.findById(jobOfferId).map(jobOffer -> {
            contract.setJobOffer(jobOffer);
            return contractRepository.save(contract);
        }).orElseThrow();
    }
}
