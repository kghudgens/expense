package com.expense.service;

import java.util.List;
import java.util.Optional;

import com.expense.entity.TransactionEntity;

public interface TransactionService {

    void createNewTransaction(TransactionEntity entity);

    Optional<TransactionEntity> getTransactionById(Long id);

    List<TransactionEntity> getAllTransactions();

    void deleteTransaction(TransactionEntity entity);

    void deleteAllTransactions();
}
