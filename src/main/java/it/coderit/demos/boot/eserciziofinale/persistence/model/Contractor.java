package it.coderit.demos.boot.eserciziofinale.persistence.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.DataAmount;
import lombok.Data;

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
    private String name;

    @Column(name = "vat_id", nullable = false, unique = true)
    private String vatId;
}
