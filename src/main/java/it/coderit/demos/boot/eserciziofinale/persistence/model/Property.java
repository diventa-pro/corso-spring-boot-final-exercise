package it.coderit.demos.boot.eserciziofinale.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.IdGeneratorType;

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
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "vat_id", nullable = false, unique = true)
    private String vatId;
}
