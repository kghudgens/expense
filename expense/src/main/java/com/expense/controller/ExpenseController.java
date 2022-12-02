package com.expense.controller;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.expense.entity.ExpenseEntity;
import com.expense.exceptions.NoRecordFoundException;
import com.expense.service.ExpenseServiceImpl;

@RestController
public class ExpenseController {

    @Inject
    private final ExpenseServiceImpl expenseServiceImpl;

    public ExpenseController(ExpenseServiceImpl expenseServiceImpl) {
        this.expenseServiceImpl = expenseServiceImpl;
    }

    @GetMapping("/expenses")
    public ResponseEntity<List<ExpenseEntity>> getAllExpenses() {
        return new ResponseEntity<>(expenseServiceImpl.findAll(), HttpStatus.OK);
    }

    @GetMapping("expeneses/{id}")
    public ResponseEntity<ExpenseEntity> getExpenseById(@PathVariable Long id) {
        Optional<ExpenseEntity> entity = expenseServiceImpl.findById(id);
        if (entity.isPresent()) {
            return new ResponseEntity<>(entity.get(), HttpStatus.OK);
        } else {
            throw new NoRecordFoundException();
        }
    }

}
