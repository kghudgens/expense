package com.expense.repository;

import com.expense.entity.ExpenseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseEntity, Long> {

}
