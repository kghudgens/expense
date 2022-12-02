package com.expense.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.expense.entity.TransactionEntity;
import com.expense.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Inject
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void createNewTransaction(TransactionEntity entity) {
        transactionRepository.save(entity);
    }

    @Override
    public Optional<TransactionEntity> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public List<TransactionEntity> getAllTransactions() {
        return (List<TransactionEntity>) transactionRepository.findAll();
    }

    @Override
    public void deleteTransaction(TransactionEntity entity) {
        transactionRepository.delete(entity);
    }

    @Override
    public void deleteAllTransactions() {
        transactionRepository.deleteAll();
    }

}
