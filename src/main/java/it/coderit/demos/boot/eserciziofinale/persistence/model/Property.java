package it.coderit.demos.boot.eserciziofinale.persistence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Table(name = "property")
@Data
/*@SequenceGenerator(
        name = "property_id_seq",
        sequenceName = "property_id_seq",
        allocationSize = 1,
        initialValue = 1000000000
)*/
public class Property {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "property_id_seq")
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "address", nullable = false)
    @NotBlank
    private String address;

    @Column(name = "vat_id", nullable = false, unique = true)
    @Length(min = 11, max = 16)
    private String vatId;
}
