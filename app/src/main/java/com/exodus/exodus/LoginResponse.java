package com.exodus.exodus;

public class LoginResponse {
    private boolean valid;
    private String message;
    private User user;

    public LoginResponse(boolean valid, String message, User user) {
        this.valid = valid;
        this.message = message;
        this.user = user;
    }

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
