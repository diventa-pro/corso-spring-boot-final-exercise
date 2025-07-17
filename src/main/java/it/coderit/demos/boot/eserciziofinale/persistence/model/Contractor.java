package it.coderit.demos.boot.eserciziofinale.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Table(name = "contractor")
@Data
public class Contractor
{
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "vat_id", nullable = false, unique = true)
    @Length(min = 11, max = 16)
    private String vatId;
}
