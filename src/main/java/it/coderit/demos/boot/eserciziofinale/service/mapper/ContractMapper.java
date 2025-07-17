package it.coderit.demos.boot.eserciziofinale.service.mapper;


import it.coderit.demos.boot.eserciziofinale.api.model.Contract;
import it.coderit.demos.boot.eserciziofinale.persistence.model.Contractor;
import it.coderit.demos.boot.eserciziofinale.persistence.model.Property;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ContractMapper {

    @Mapping(target = "id.startDate", source = "request.startDate")
    @Mapping(target = "id.contractor", source = "contractor")
    @Mapping(target = "id.property", source = "property")
    it.coderit.demos.boot.eserciziofinale.persistence.model.Contract fromApiModel(Contract request, Contractor contractor, Property property);

    @Mapping(source = "id.startDate", target = "startDate")
    @Mapping(source = "id.contractor.id", target = "contractorId")
    @Mapping(source = "id.property.id", target = "propertyId")
    Contract toApiModel(it.coderit.demos.boot.eserciziofinale.persistence.model.Contract contract);
}
