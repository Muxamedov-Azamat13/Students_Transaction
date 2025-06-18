package com.example.demo.controller;

import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionalController {

    private TransactionService transactionService;

    public TransactionalController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/students/{studentId}/transactions")
    public Transaction addTransaction(@PathVariable Long studentId, @RequestBody Transaction transaction) {
        return transactionService.addTransaction(studentId, transaction);
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions(@RequestParam LocalDate from,
                                             @RequestParam LocalDate to,
                                             @RequestParam BigDecimal minAmount) {
        return transactionService.getAllWithFilter(from, to, minAmount);
    }

    @GetMapping("/transactions/{id}")
    public Transaction getById(@PathVariable Long id) {
        return transactionService.getById(id);
    }

    @PutMapping("/transactions/{id}")
    public Transaction update(@PathVariable Long id, @RequestBody Transaction transaction) {
        return transactionService.update(id, transaction);
    }

    @DeleteMapping("/transactions/{id}")
    public void delete(@PathVariable Long id) {
        transactionService.delete(id);
    }

    @GetMapping("/students/{studentId}/transactions")
    public Transaction getByStudent(@PathVariable Long studentId) {
        return transactionService.getByStudent(studentId);
    }
}
