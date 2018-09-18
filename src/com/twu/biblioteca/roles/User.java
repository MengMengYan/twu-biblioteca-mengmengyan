package com.twu.biblioteca.roles;

public class User implements Role {
    private String username;
    private RoleType roleType;
    private String name;
    private String mail;
    private String phone;

    public User(String username) {
        this.roleType = RoleType.USER;
        this.username = username;
        retrieveMockUserInformation(username);
    }

    private void retrieveMockUserInformation(String username) {
        switch (username) {
            case "777-7777":
                this.name = "Examplename";
                this.mail = "example@mail.com";
                this.phone = "010101";
                break;
            default:
                this.name = "not available";
                this.mail = "not available";
                this.phone = "not available";
        }
    }

    public String getUsername() {
        return username;
    }

    public RoleType getRoleType() {
        return roleType;
    }


    public String getUserInformation() {
        return "Name: " + name + "\nMail: " + mail + "\nPhone: " + phone;
    }
}
