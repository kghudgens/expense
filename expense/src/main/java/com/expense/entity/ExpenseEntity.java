package com.expense.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expenses")
public class ExpenseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String details;
    private String owedTo;
    private int amount;
    private boolean mandatory;
    private boolean recurring;
    private Date dateDue;

    public ExpenseEntity(Long id, String name, String details, String owedTo, int amount, boolean mandatory,
            boolean recurring, Date dateDue) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.owedTo = owedTo;
        this.amount = amount;
        this.mandatory = mandatory;
        this.recurring = recurring;
        this.dateDue = dateDue;
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

    public String getOwedTo() {
        return this.owedTo;
    }

    public void setOwedTo(String owedTo) {
        this.owedTo = owedTo;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isMandatory() {
        return this.mandatory;
    }

    public boolean getMandatory() {
        return this.mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public boolean isRecurring() {
        return this.recurring;
    }

    public boolean getRecurring() {
        return this.recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public Date getDateDue() {
        return this.dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    public ExpenseEntity id(Long id) {
        setId(id);
        return this;
    }

    public ExpenseEntity name(String name) {
        setName(name);
        return this;
    }

    public ExpenseEntity details(String details) {
        setDetails(details);
        return this;
    }

    public ExpenseEntity owedTo(String owedTo) {
        setOwedTo(owedTo);
        return this;
    }

    public ExpenseEntity amount(int amount) {
        setAmount(amount);
        return this;
    }

    public ExpenseEntity mandatory(boolean mandatory) {
        setMandatory(mandatory);
        return this;
    }

    public ExpenseEntity recurring(boolean recurring) {
        setRecurring(recurring);
        return this;
    }

    public ExpenseEntity dateDue(Date dateDue) {
        setDateDue(dateDue);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ExpenseEntity)) {
            return false;
        }
        ExpenseEntity expenseEntity = (ExpenseEntity) o;
        return id == expenseEntity.id && Objects.equals(name, expenseEntity.name)
                && Objects.equals(details, expenseEntity.details) && Objects.equals(owedTo, expenseEntity.owedTo)
                && amount == expenseEntity.amount && mandatory == expenseEntity.mandatory
                && recurring == expenseEntity.recurring && Objects.equals(dateDue, expenseEntity.dateDue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, details, owedTo, amount, mandatory, recurring, dateDue);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", details='" + getDetails() + "'" +
                ", owedTo='" + getOwedTo() + "'" +
                ", amount='" + getAmount() + "'" +
                ", mandatory='" + isMandatory() + "'" +
                ", recurring='" + isRecurring() + "'" +
                ", dateDue='" + getDateDue() + "'" +
                "}";
    }

    public ExpenseEntity() {
    }

}
