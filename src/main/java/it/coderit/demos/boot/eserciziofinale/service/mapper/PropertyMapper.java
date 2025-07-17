package it.coderit.demos.boot.eserciziofinale.service.mapper;


import it.coderit.demos.boot.eserciziofinale.api.model.CreateProperty;
import it.coderit.demos.boot.eserciziofinale.persistence.model.Property;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PropertyMapper {
    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    Property fromCreateRequest(CreateProperty request);
}
