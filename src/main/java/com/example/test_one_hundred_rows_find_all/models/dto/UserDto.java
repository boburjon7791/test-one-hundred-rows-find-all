package com.example.test_one_hundred_rows_find_all.models.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.test_one_hundred_rows_find_all.models.entities.User}
 */
public class UserDto implements Serializable {
    private final Long id;
    private final String fullName;

    public UserDto(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.fullName, entity.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "fullName = " + fullName + ")";
    }
}