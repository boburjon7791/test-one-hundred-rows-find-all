package com.example.test_one_hundred_rows_find_all.repository;

import com.example.test_one_hundred_rows_find_all.models.entities.Transaction;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {
  // attributePaths dagi qiymatlar Transaction entity dagi relation bo'lib bog'langan entity field lar nomi bilan bir xil bo'lishi kerak
  @Override
  @EntityGraph(attributePaths = {"fromUser", "toUser", "fromCard", "toCard"})
  List<Transaction> findAll();
}