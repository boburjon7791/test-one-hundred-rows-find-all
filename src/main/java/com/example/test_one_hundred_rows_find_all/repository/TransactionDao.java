package com.example.test_one_hundred_rows_find_all.repository;

import com.example.test_one_hundred_rows_find_all.models.entities.Transaction;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDao {
    @PersistenceContext
    private final EntityManager entityManager;

    public TransactionDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Transaction> findAll() {
        // addAttributeNodes metodiga Transaction entity dagi relation bo'lib bog'langan entity field lar nomlarini yozishimiz kerak
        EntityGraph<Transaction> entityGraph = entityManager.createEntityGraph(Transaction.class);
        entityGraph.addAttributeNodes("fromUser");
        entityGraph.addAttributeNodes("toUser");
        entityGraph.addAttributeNodes("fromCard");
        entityGraph.addAttributeNodes("toCard");
        return entityManager.createQuery("from Transaction", Transaction.class)
                .setHint("jakarta.persistence.loadgraph", entityGraph)  // agar java ee ishlatayotgan bo'lsanginz jakarta ning o'rniga javax deb yozish kerak
                .getResultList();
    }
}
