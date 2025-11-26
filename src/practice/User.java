package practice;

import practice.exceptions.AuthenticationException;
import practice.exceptions.ExcessiveFailedLoginException;

public class User {
    private String username;
    private String password;
    private int failedLoginAttempt;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.failedLoginAttempt = 0;
    }

    public void login(String username, String password)
            throws AuthenticationException, ExcessiveFailedLoginException {

        if (!this.username.equals(username) || !this.password.equals(password)) {
            failedLoginAttempt++;

            if (failedLoginAttempt >= 3) {
                throw new ExcessiveFailedLoginException("Too many failed login attempts!");
            }

            throw new AuthenticationException("Incorrect username or password!");
        }

        failedLoginAttempt = 0;
        System.out.println("Login success!");
    }
}
