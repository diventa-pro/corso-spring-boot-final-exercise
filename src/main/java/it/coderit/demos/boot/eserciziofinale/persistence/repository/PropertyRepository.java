package it.coderit.demos.boot.eserciziofinale.persistence.repository;

import it.coderit.demos.boot.eserciziofinale.persistence.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PropertyRepository extends JpaRepository<Property, UUID> {
}
