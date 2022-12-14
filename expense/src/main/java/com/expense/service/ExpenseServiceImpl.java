package com.expense.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.expense.entity.ExpenseEntity;
import com.expense.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Inject
    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<ExpenseEntity> findAll() {
        return (List<ExpenseEntity>) expenseRepository.findAll();
    }

    @Override
    public void createNewExpense(ExpenseEntity entity) {
        expenseRepository.save(entity);
    }

    @Override
    public void deleteExpense(ExpenseEntity entity) {
        expenseRepository.delete(entity);
    }

    @Override
    public Optional<ExpenseEntity> findById(Long id) {
        return expenseRepository.findById(id);
    }

    @Override
    public void deleteAllExpenses() {
        expenseRepository.deleteAll();
    }

}
