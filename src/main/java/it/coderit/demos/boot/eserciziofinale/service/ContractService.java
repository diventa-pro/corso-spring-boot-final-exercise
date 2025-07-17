package it.coderit.demos.boot.eserciziofinale.service;

import it.coderit.demos.boot.eserciziofinale.api.model.Contract;
import it.coderit.demos.boot.eserciziofinale.persistence.model.Contractor;
import it.coderit.demos.boot.eserciziofinale.persistence.model.Property;
import it.coderit.demos.boot.eserciziofinale.persistence.repository.ContractRepository;
import it.coderit.demos.boot.eserciziofinale.persistence.repository.ContractorRepository;
import it.coderit.demos.boot.eserciziofinale.persistence.repository.PropertyRepository;
import it.coderit.demos.boot.eserciziofinale.service.mapper.ContractMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
@RequiredArgsConstructor
@Log
public class ContractService {

    private final ContractMapper mapper;
    private final PropertyRepository propertyRepository;
    private final ContractorRepository contractorRepository;
    private final ContractRepository repository;
    private final KafkaTemplate<String, Contract> kafkaTemplate;


    @Transactional
    public Contract createContract(Contract request) throws InterruptedException, ExecutionException, TimeoutException {
        Contractor contractor = contractorRepository.getReferenceById(request.getContractorId());
        Property property = propertyRepository.getReferenceById(request.getPropertyId());
        it.coderit.demos.boot.eserciziofinale.persistence.model.Contract contract = mapper.fromApiModel(request, contractor, property);
        it.coderit.demos.boot.eserciziofinale.persistence.model.Contract dbModel = repository.save(contract);
        var response = mapper.toApiModel(dbModel);

        kafkaTemplate.send(
                "contracts.events",
                response
        ).get(1, TimeUnit.SECONDS) ;

        return response;
    }

    public List<Contract> findAll() {
        return repository.findAll().stream().map(mapper::toApiModel).toList();
    }

    @KafkaListener(topics = "contracts.events")
    public void listen(Contract contract) {
        log.info("Received contract: " + contract);
    }
}
