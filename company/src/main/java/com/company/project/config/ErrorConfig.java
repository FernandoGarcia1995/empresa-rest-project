package com.company.project.config;

public enum ErrorConfig {
	
    ERR_USER_EXISTS("Usuario existe en la base de datos"),
	ERR_DEPARTMENT_NOT_FOUND("El departamento no existe en la base de datos");

    private final String value;

    private ErrorConfig(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
