package it.coderit.demos.boot.eserciziofinale.api;

import it.coderit.demos.boot.eserciziofinale.api.model.Contract;
import it.coderit.demos.boot.eserciziofinale.service.ContractService;
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
    private final ContractService contractService;

    @PostMapping
    @RolesAllowed({"ROLE_ADMIN"})
    public Contract create(@RequestBody @Valid Contract request) throws Exception {
        return contractService.createContract(request);
    }

    @GetMapping
    @PermitAll
    public List<Contract> findAll() {
        return contractService.findAll();
    }
}
