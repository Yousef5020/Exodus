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

    boolean isValid() {
        return valid;
    }

    String getMessage() {
        return message;
    }

    User getUser() {
        return user;
    }
}
