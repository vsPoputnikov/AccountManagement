package com.example.accountManagement.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class User {
    private final long id;
    @NotBlank
    private final String fullName;

    public User(@JsonProperty("id") long id, @JsonProperty("fullname") String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
}
