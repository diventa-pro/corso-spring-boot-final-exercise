package it.coderit.demos.boot.eserciziofinale.api;

import it.coderit.demos.boot.eserciziofinale.api.model.CreateContractor;
import it.coderit.demos.boot.eserciziofinale.persistence.model.Contractor;
import it.coderit.demos.boot.eserciziofinale.persistence.repository.ContractorRepository;
import it.coderit.demos.boot.eserciziofinale.service.mapper.ContractorMapper;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contractor")
@RequiredArgsConstructor
@DenyAll
public class ContractorApi {
    private final ContractorRepository repository;
    private final ContractorMapper mapper;

    @PostMapping
    @RolesAllowed({"ROLE_ADMIN"})
    public Contractor create(@RequestBody @Valid CreateContractor request) {
        Contractor contractor = mapper.fromCreateRequest(request);
        return repository.save(contractor);
    }
}
