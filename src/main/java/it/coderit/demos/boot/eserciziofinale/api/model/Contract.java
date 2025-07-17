package it.coderit.demos.boot.eserciziofinale.api.model;

import it.coderit.demos.boot.eserciziofinale.api.validation.EndDateAfterStartDate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@EndDateAfterStartDate
public class Contract {
    @NotNull
    private UUID contractorId;
    @NotNull
    private UUID propertyId;
    @NotNull
    private LocalDate startDate;
    private LocalDate endDate;
}
