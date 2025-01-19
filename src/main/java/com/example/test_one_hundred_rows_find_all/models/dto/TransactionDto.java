package com.example.test_one_hundred_rows_find_all.models.dto;

import com.example.test_one_hundred_rows_find_all.models.entities.Transaction;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO for {@link Transaction}
 */
public class TransactionDto implements Serializable {
    private final Long id;
    private final UserDto fromUser;
    private final UserDto toUser;
    private final CardDto fromCard;
    private final CardDto toCard;
    private final BigDecimal amount;

    public TransactionDto(Long id, UserDto fromUser, UserDto toUser, CardDto fromCard, CardDto toCard, BigDecimal amount) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.fromCard = fromCard;
        this.toCard = toCard;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public UserDto getFromUser() {
        return fromUser;
    }

    public UserDto getToUser() {
        return toUser;
    }

    public CardDto getFromCard() {
        return fromCard;
    }

    public CardDto getToCard() {
        return toCard;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDto entity = (TransactionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.fromUser, entity.fromUser) &&
                Objects.equals(this.toUser, entity.toUser) &&
                Objects.equals(this.fromCard, entity.fromCard) &&
                Objects.equals(this.toCard, entity.toCard) &&
                Objects.equals(this.amount, entity.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromUser, toUser, fromCard, toCard, amount);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "fromUser = " + fromUser + ", " +
                "toUser = " + toUser + ", " +
                "fromCard = " + fromCard + ", " +
                "toCard = " + toCard + ", " +
                "amount = " + amount + ")";
    }
}