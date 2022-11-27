package com.expense.service;

import java.util.List;
import java.util.Optional;

import com.expense.entity.ExpenseEntity;

public interface ExpenseService {

    List<ExpenseEntity> findAll();

    void createNewExpense(ExpenseEntity entity);

    void deleteExpense(ExpenseEntity entity);

    Optional<ExpenseEntity> findById(Long id);

    void deleteAllExpenses();

}
