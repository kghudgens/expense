package com.expense.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.expense.entity.TransactionEntity;
import com.expense.exceptions.NoRecordFoundException;
import com.expense.service.TransactionService;

public class TransactionController {
    @Inject
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionEntity>> getAllTransactions() {
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("expeneses/{id}")
    public ResponseEntity<TransactionEntity> getTransactionById(@PathVariable Long id) {
        Optional<TransactionEntity> entity = transactionService.getTransactionById(id);
        if (entity.isPresent()) {
            return new ResponseEntity<>(entity.get(), HttpStatus.OK);
        } else {
            throw new NoRecordFoundException();
        }
    }

    @PostMapping("Transactions/new")
    public ResponseEntity<TransactionEntity> createTransaction(@RequestBody TransactionEntity entity) {
        transactionService.createNewTransaction(entity);
        if (Objects.isNull(entity)) {
            return new ResponseEntity<TransactionEntity>(entity, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<TransactionEntity>(entity, HttpStatus.OK);
    }

    @PutMapping("Transactions/{id}/update")
    public ResponseEntity<TransactionEntity> updateTransaction(@PathVariable Long id,
            @RequestBody TransactionEntity entity) {
        TransactionEntity e = transactionService.getTransactionById(id)
                .orElseThrow(() -> new NoRecordFoundException("Entity does not exist", HttpStatus.NO_CONTENT));

        e.setName(entity.getName());
        e.setDetails(entity.getDetails());
        e.setDate(entity.getDate());
        e.setPaidTo(entity.getPaidTo());
        e.setAmount(entity.getAmount());

        transactionService.createNewTransaction(e);

        return new ResponseEntity<TransactionEntity>(e, HttpStatus.OK);
    }

    @DeleteMapping("Transactions/{id}/delete")
    public ResponseEntity<TransactionEntity> deleteTransaction(@PathVariable Long id) {
        TransactionEntity entity = transactionService.getTransactionById(id)
                .orElseThrow(() -> new NoRecordFoundException("Transaction does not exist", HttpStatus.NO_CONTENT));
        transactionService.deleteTransaction(entity);
        return new ResponseEntity<TransactionEntity>(entity, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("Transactions/deleteAll")
    public ResponseEntity<TransactionEntity> deleteAllTransactions() {
        transactionService.deleteAllTransactions();
        return new ResponseEntity<TransactionEntity>(HttpStatus.OK);
    }
}
