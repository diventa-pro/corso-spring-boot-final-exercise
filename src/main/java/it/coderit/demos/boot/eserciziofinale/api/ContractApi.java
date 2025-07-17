package it.coderit.demos.boot.eserciziofinale.api;

import it.coderit.demos.boot.eserciziofinale.api.model.Contract;
import it.coderit.demos.boot.eserciziofinale.persistence.model.Contractor;
import it.coderit.demos.boot.eserciziofinale.persistence.model.Property;
import it.coderit.demos.boot.eserciziofinale.persistence.repository.ContractRepository;
import it.coderit.demos.boot.eserciziofinale.persistence.repository.ContractorRepository;
import it.coderit.demos.boot.eserciziofinale.persistence.repository.PropertyRepository;
import it.coderit.demos.boot.eserciziofinale.service.mapper.ContractMapper;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
@RequiredArgsConstructor
@DenyAll
public class ContractApi {
    private final ContractRepository repository;
    private final ContractorRepository contractorRepository;
    private final PropertyRepository propertyRepository;
    private final ContractMapper mapper;

    @PostMapping
    @RolesAllowed({"ROLE_ADMIN"})
    public Contract create(@RequestBody @Valid Contract request) {
        Contractor contractor = contractorRepository.getReferenceById(request.getContractorId());
        Property property = propertyRepository.getReferenceById(request.getPropertyId());
        it.coderit.demos.boot.eserciziofinale.persistence.model.Contract contract = mapper.fromApiModel(request, contractor, property);
        it.coderit.demos.boot.eserciziofinale.persistence.model.Contract dbModel = repository.save(contract);
        return mapper.toApiModel(dbModel);
    }

    @GetMapping
    @PermitAll
    public List<Contract> findAll() {
        return repository.findAll().stream().map(mapper::toApiModel).toList();
    }
}
