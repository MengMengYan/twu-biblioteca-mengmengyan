package com.twu.biblioteca.roles;

public class Librarian implements Role {
    private String username;
    private RoleType roleType;

    public Librarian(String username) {
        this.roleType = RoleType.LIBRARIAN;
        this.username = username;
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public RoleType getRoleType() {
        return roleType;
    }
}
