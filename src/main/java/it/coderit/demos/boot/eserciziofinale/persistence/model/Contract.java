package it.coderit.demos.boot.eserciziofinale.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "contract",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"property_id", "contractor_id", "start_date"}
                )
        }
)
@Data
public class Contract {

    @Data
    @Embeddable
    public static class ContractPK {
        @Column(name = "property_id", nullable = false, insertable = false, updatable = false)
        private UUID propertyId;
        @Column(name = "contractor_id", nullable = false, insertable = false, updatable = false)
        private UUID contractorId;
        @Column(name = "start_date", nullable = false, insertable = false, updatable = false)
        private LocalDate startDate;
    }


    @Id
    @EmbeddedId
    private ContractPK id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @ManyToOne(optional = false)
    @JoinColumn(name = "contractor_id", nullable = false)
    private Contractor contractor;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

}
