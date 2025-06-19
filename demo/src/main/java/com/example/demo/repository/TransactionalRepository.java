package com.example.demo.repository;

import com.example.demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionalRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findByDateBetweenAndAmountGreaterThanEqual(
            LocalDate from, LocalDate to, BigDecimal minAmount
    );

    @Query("SELECT SUM(t.amount), COUNT(t) FROM Transaction t WHERE t.date BETWEEN :from AND :to")
    Object[] getSummary(LocalDate from, LocalDate to);


}
