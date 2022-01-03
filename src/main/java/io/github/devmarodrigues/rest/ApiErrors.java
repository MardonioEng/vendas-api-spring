package io.github.devmarodrigues.rest;

import lombok.Getter;

import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> errors;

    public ApiErrors(String error) {
        this.errors = List.of(error);
    }
}
