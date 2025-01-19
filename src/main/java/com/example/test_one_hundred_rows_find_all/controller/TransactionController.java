package com.example.test_one_hundred_rows_find_all.controller;

import com.example.test_one_hundred_rows_find_all.models.dto.CardDto;
import com.example.test_one_hundred_rows_find_all.models.dto.TransactionDto;
import com.example.test_one_hundred_rows_find_all.models.dto.UserDto;
import com.example.test_one_hundred_rows_find_all.models.entities.Card;
import com.example.test_one_hundred_rows_find_all.models.entities.User;
import com.example.test_one_hundred_rows_find_all.repository.TransactionDao;
import com.example.test_one_hundred_rows_find_all.repository.TransactionRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private final TransactionRepository transactionRepository;
    private final TransactionDao transactionDao;

    public TransactionController(TransactionRepository transactionRepository, TransactionDao transactionDao) {
        this.transactionRepository = transactionRepository;
        this.transactionDao = transactionDao;
    }

    @GetMapping
    public List<TransactionDto> getAllTransactions(HttpServletResponse response) {
        return transactionRepository.findAll().stream()
                .map(transaction -> {
                    User fromUser = transaction.getFromUser();
                    User toUser = transaction.getToUser();
                    Card fromCard = transaction.getFromCard();
                    Card toCard = transaction.getToCard();
                    return new TransactionDto(
                            transaction.getId(),
                            new UserDto(fromUser.getId(), fromUser.getFullName()),
                            new UserDto(toUser.getId(), toUser.getFullName()),
                            new CardDto(fromCard.getId(), toCard.getCardType(), fromCard.getCardNumber()),
                            new CardDto(toCard.getId(), toCard.getCardType(), toCard.getCardNumber()),
                            transaction.getAmount()
                    );
                }).toList();
    }
}
