package com.twu.biblioteca.roles;

public class Guest implements Role {
    private String username;
    private RoleType roleType;

    public Guest() {
        this.roleType = RoleType.GUEST;
        this.username = "Guest user";
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
