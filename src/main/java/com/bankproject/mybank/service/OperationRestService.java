package com.bankproject.mybank.service;

import com.bankproject.mybank.dao.CompteRepository;
import com.bankproject.mybank.dao.OperationRepository;
import com.bankproject.mybank.entities.Compte;
import com.bankproject.mybank.entities.Operation;
import com.bankproject.mybank.entities.Retrait;
import com.bankproject.mybank.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Transactional
public class OperationRestService {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository compteRepository;
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/operations",method = RequestMethod.GET)
    public List<Operation> operations(){
        return operationRepository.findOperations();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/versement",method = RequestMethod.POST)
    public void verser(@RequestParam(name = "m") double montant){
        Compte cp = this.compteRepository.getById("cp1");
        Versement v = new Versement(new Date(),montant,cp);
        operationRepository.save(v);
        cp.setSolde(cp.getSolde()+montant);
        compteRepository.save(cp);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/retrait",method = RequestMethod.POST)
    public void retirer(@RequestParam(name = "m") double montant){
        Compte cp = this.compteRepository.getById("cp1");
        Retrait v = new Retrait(new Date(),montant,cp);
        operationRepository.save(v);
        if(cp.getSolde()<montant) throw new RuntimeException("solde insuffisant");
        else {
            cp.setSolde(cp.getSolde()-montant);
            compteRepository.save(cp);
        }
    }
}
