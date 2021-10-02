package pe.edu.upc.joboffersservice.services;

import pe.edu.upc.joboffersservice.entities.Contract;
import pe.edu.upc.joboffersservice.services.common.CrudService;

import java.util.List;

public interface ContractService extends CrudService<Contract, Long> {
    List<Contract> findByJobOfferId(Long offerId) throws Exception;

    Contract saveByJobOfferId(Long jobOfferId, Contract contract) throws Exception;
}
