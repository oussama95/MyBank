package com.bankproject.mybank.dao;

import com.bankproject.mybank.entities.Compte;
import com.bankproject.mybank.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation,Long> {
    @Query("select o.numero,o.dateOperation,o.montant,o.compte.codeCompte from Operation o")
    public List<Operation> findOperations();
}
