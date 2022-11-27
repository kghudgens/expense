package com.expense.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "transactions")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String details;
    private int amount;
    private String paidTo;
    private Date date;

    public TransactionEntity() {
    }

    public TransactionEntity(Long id, String name, String details, int amount, String paidTo, Date date) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.amount = amount;
        this.paidTo = paidTo;
        this.date = date;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPaidTo() {
        return this.paidTo;
    }

    public void setPaidTo(String paidTo) {
        this.paidTo = paidTo;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransactionEntity id(Long id) {
        setId(id);
        return this;
    }

    public TransactionEntity name(String name) {
        setName(name);
        return this;
    }

    public TransactionEntity details(String details) {
        setDetails(details);
        return this;
    }

    public TransactionEntity amount(int amount) {
        setAmount(amount);
        return this;
    }

    public TransactionEntity paidTo(String paidTo) {
        setPaidTo(paidTo);
        return this;
    }

    public TransactionEntity date(Date date) {
        setDate(date);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TransactionEntity)) {
            return false;
        }
        TransactionEntity transactionEntity = (TransactionEntity) o;
        return Objects.equals(id, transactionEntity.id) && Objects.equals(name, transactionEntity.name)
                && Objects.equals(details, transactionEntity.details) && amount == transactionEntity.amount
                && Objects.equals(paidTo, transactionEntity.paidTo) && Objects.equals(date, transactionEntity.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, details, amount, paidTo, date);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", details='" + getDetails() + "'" +
                ", amount='" + getAmount() + "'" +
                ", paidTo='" + getPaidTo() + "'" +
                ", date='" + getDate() + "'" +
                "}";
    }

}
