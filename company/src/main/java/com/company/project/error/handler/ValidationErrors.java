package com.company.project.error.handler;
import java.util.HashMap;
import java.util.Map;

public class ValidationErrors {
    private Map<String, String> errors = new HashMap<>();

    public ValidationErrors() {}

    public void addError(String field, String message) {
        errors.put(field, message);
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}