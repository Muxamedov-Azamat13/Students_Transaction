package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.Transaction;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TransactionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    private TransactionalRepository transactionRepository;

    private StudentRepository studentRepository;

    public TransactionService(TransactionalRepository transactionRepository, StudentRepository studentRepository) {
        this.transactionRepository = transactionRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Transaction addTransaction(Long studentId, Transaction transaction) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
        transaction.setStudent(student);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllWithFilter(LocalDate from, LocalDate to, BigDecimal minAmount) {
        return transactionRepository.findByDateBetweenAndAmountGreaterThanEqual(from, to, minAmount);
    }

    public Transaction getByStudent(Long studentId) {
        return transactionRepository.findById(studentId).orElseThrow();
    }

    public Transaction getById(Long id) {
        return transactionRepository.findById(id).orElseThrow();
    }

    public Transaction update(Long id, Transaction updated) {
        Transaction transaction = getById(id);
        transaction.setAmount(updated.getAmount());
        transaction.setDate(updated.getDate());
        transaction.setComment(updated.getComment());
        return transactionRepository.save(transaction);
    }

    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }
}
