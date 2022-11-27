package com.expense.service;

import java.util.List;

import com.expense.entity.TransactionEntity;

public interface TransactionService {

    void createNewTransaction();

    void viewTransaction(Long id);

    List<TransactionEntity> viewAllTransactions();

    void deleteTransaction(TransactionEntity entity);

    void deleteAllTransactions();
}
