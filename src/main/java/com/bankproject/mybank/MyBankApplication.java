package com.bankproject.mybank;

import com.bankproject.mybank.dao.CompteRepository;
import com.bankproject.mybank.dao.OperationRepository;
import com.bankproject.mybank.entities.Compte;
import com.bankproject.mybank.entities.Operation;
import com.bankproject.mybank.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class MyBankApplication implements CommandLineRunner {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    public static void main(String[] args) {
        SpringApplication.run(MyBankApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Compte cp1 = compteRepository.save(new Compte("cp1",9000,null));
        Operation o1 = operationRepository.save(new Versement(new Date(),1000,cp1));
    }
}
