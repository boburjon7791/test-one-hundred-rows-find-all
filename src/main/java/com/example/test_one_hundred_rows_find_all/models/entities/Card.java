package com.example.test_one_hundred_rows_find_all.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_id_gen")
    @SequenceGenerator(name = "card_id_gen", sequenceName = "card_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "card_type", nullable = false, length = Integer.MAX_VALUE)
    private String cardType;

    @Column(name = "card_number", nullable = false, length = Integer.MAX_VALUE)
    private String cardNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}