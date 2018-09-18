package com.twu.biblioteca.roles;

public class User implements Role {
    private String username;
    private RoleType roleType;

    public User(String username) {
        this.roleType = RoleType.USER;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public RoleType getRoleType() {
        return roleType;
    }


}
