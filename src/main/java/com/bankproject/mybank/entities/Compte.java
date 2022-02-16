package com.bankproject.mybank.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Compte implements Serializable {
    @Id
    private String codeCompte;
    private double solde;
    @OneToMany(mappedBy="compte")
    private Collection<Operation> operations;

    public Compte() {
        super();
    }

    public Compte(String codeCompte, double solde, Collection<Operation> operations) {
        this.codeCompte = codeCompte;
        this.solde = solde;
        this.operations = operations;
    }

    public String getCodeCompte() {
        return codeCompte;
    }

    public void setCodeCompte(String codeCompte) {
        this.codeCompte = codeCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }
}
