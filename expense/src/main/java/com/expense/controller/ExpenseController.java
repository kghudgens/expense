package com.expense.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.inject.Inject;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expense.entity.ExpenseEntity;
import com.expense.exceptions.NoRecordFoundException;
import com.expense.service.ExpenseService;

@RestController
public class ExpenseController {

    @Inject
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public ResponseEntity<List<ExpenseEntity>> getAllExpenses() {
        return new ResponseEntity<>(expenseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("expeneses/{id}")
    public ResponseEntity<ExpenseEntity> getExpenseById(@PathVariable Long id) {
        Optional<ExpenseEntity> entity = expenseService.findById(id);
        if (entity.isPresent()) {
            return new ResponseEntity<>(entity.get(), HttpStatus.OK);
        } else {
            throw new NoRecordFoundException();
        }
    }

    @PostMapping("expenses/new")
    public ResponseEntity<ExpenseEntity> createExpense(@RequestBody ExpenseEntity entity) {
        expenseService.createNewExpense(entity);
        if (Objects.isNull(entity)) {
            return new ResponseEntity<ExpenseEntity>(entity, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ExpenseEntity>(entity, HttpStatus.OK);
    }

    @PutMapping("expenses/{id}/update")
    public ResponseEntity<ExpenseEntity> updateExpense(@PathVariable Long id, @RequestBody ExpenseEntity entity) {
        ExpenseEntity e = expenseService.findById(id)
                .orElseThrow(() -> new NoRecordFoundException("Entity does not exist", HttpStatus.NO_CONTENT));

        e.setName(entity.getName());
        e.setDetails(entity.getDetails());
        e.setOwedTo(entity.getOwedTo());
        e.setDateDue(entity.getDateDue());
        e.setAmount(entity.getAmount());
        e.setRecurring(entity.getRecurring());

        expenseService.createNewExpense(e);

        return new ResponseEntity<ExpenseEntity>(e, HttpStatus.OK);
    }

    @DeleteMapping("expenses/{id}/delete")
    public ResponseEntity<ExpenseEntity> deleteExpense(@PathVariable Long id) {
        ExpenseEntity entity = expenseService.findById(id)
                .orElseThrow(() -> new NoRecordFoundException("Expense does not exist", HttpStatus.NO_CONTENT));
        expenseService.deleteExpense(entity);
        return new ResponseEntity<ExpenseEntity>(entity, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("expenses/deleteAll")
    public ResponseEntity<ExpenseEntity> deleteAllExpenses() {
        expenseService.deleteAllExpenses();
        return new ResponseEntity<ExpenseEntity>(HttpStatus.OK);
    }

}
