package com.agriculture.project.model.value;

public enum Role {

    ROLE_ADMIN("ADMIN"),

    ROLE_USER("FARMER"),

    ROLE_MODULE("MODULE");

    private final String role;

    private Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
