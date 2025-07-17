package it.coderit.demos.boot.eserciziofinale.persistence.repository;

import it.coderit.demos.boot.eserciziofinale.persistence.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Contract.ContractPK> {
}
