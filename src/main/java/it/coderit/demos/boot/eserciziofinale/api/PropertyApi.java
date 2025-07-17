package it.coderit.demos.boot.eserciziofinale.api;

import it.coderit.demos.boot.eserciziofinale.api.model.CreateProperty;
import it.coderit.demos.boot.eserciziofinale.persistence.model.Property;
import it.coderit.demos.boot.eserciziofinale.persistence.repository.PropertyRepository;
import it.coderit.demos.boot.eserciziofinale.service.mapper.PropertyMapper;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/property")
@RequiredArgsConstructor
@DenyAll
public class PropertyApi {

    private final PropertyRepository repository;
    private final PropertyMapper mapper;

    @PostMapping
    @RolesAllowed({"ROLE_ADMIN"})
    public Property create(@RequestBody @Valid CreateProperty request) {
        Property property = mapper.fromCreateRequest(request);
        return repository.save(property);
    }
}
