package com.example.test_one_hundred_rows_find_all.models.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.test_one_hundred_rows_find_all.models.entities.Card}
 */
public class CardDto implements Serializable {
    private final Long id;
    private final String cardType;
    private final String cardNumber;

    public CardDto(Long id, String cardType, String cardNumber) {
        this.id = id;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    public Long getId() {
        return id;
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardDto entity = (CardDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.cardType, entity.cardType) &&
                Objects.equals(this.cardNumber, entity.cardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardType, cardNumber);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "cardType = " + cardType + ", " +
                "cardNumber = " + cardNumber + ")";
    }
}