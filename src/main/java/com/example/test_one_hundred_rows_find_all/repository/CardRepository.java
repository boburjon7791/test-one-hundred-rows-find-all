package com.example.test_one_hundred_rows_find_all.repository;

import com.example.test_one_hundred_rows_find_all.models.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CardRepository extends JpaRepository<Card, Long>, JpaSpecificationExecutor<Card> {
}