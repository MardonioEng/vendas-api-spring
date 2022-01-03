package io.github.devmarodrigues.rest;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> errors;

    public ApiErrors(List<String> errors) {
        this.errors = errors;
    }

    public ApiErrors(String error) {
        this.errors = List.of(error);
    }
}
