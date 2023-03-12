package com.company.project.model;

public enum Rol {
	
    ROLE_EMPLOYEE("EMPLOYEE"),
    ROLE_ADMIN("ADMIN");

    private final String value;

    private Rol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
