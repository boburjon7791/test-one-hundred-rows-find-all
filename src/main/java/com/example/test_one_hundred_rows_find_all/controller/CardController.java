package com.example.test_one_hundred_rows_find_all.controller;

import com.example.test_one_hundred_rows_find_all.models.dto.CardDto;
import com.example.test_one_hundred_rows_find_all.repository.CardRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {
    private final CardRepository cardRepository;

    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping
    public List<CardDto> findAll() {
        return cardRepository.findAll().stream().map(card -> new CardDto(card.getId(), card.getCardType(), card.getCardNumber())).toList();
    }
}
