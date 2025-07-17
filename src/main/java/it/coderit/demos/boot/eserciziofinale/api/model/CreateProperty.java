package it.coderit.demos.boot.eserciziofinale.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateProperty {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String address;
    @NotNull
    @Length(min = 11, max = 16)
    private String vatId;
}
