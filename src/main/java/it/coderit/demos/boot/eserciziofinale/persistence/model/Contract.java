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
        @ManyToOne(optional = false)
        @JoinColumn(name = "property_id", nullable = false)
        private Property property;
        @ManyToOne(optional = false)
        @JoinColumn(name = "contractor_id", nullable = false)
        private Contractor contractor;
        @Column(name = "start_date", nullable = false)
        private LocalDate startDate;
    }


    @Id
    @EmbeddedId
    private ContractPK id;

    @Column(name = "end_date")
    private LocalDate endDate;

}
