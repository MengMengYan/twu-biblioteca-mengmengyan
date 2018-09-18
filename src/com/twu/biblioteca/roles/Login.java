package com.twu.biblioteca.roles;

import java.util.HashMap;

public class Login {
    private HashMap<String, String> users;

    public Login() {
        users = new HashMap<>();
        users.put("111-1111", "xyz");
        users.put("777-7777", "abc");
    }


    public Role login(String username, String password) {
        String usernameFormat = "\\d\\d\\d-\\d\\d\\d\\d";
        if (username.matches(usernameFormat)) {
            if (users.get(username).equals(password))
                if (username.equals("111-1111"))
                    return new Librarian("111-1111");
                else if (username.equals("777-7777"))
                    return new User("777-7777");
        }
        return new Guest();
    }
}
