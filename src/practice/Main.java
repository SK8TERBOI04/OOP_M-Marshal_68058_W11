package practice;

import practice.exceptions.AuthenticationException;
import practice.exceptions.ExcessiveFailedLoginException;

public class Main {
    public static void main(String[] args) {
        User user = new User("admin", "admin");

        try {
            user.login("admin", "xxx");
        } catch (ExcessiveFailedLoginException e) {
            System.out.println(e.getMessage());
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
        }
    }
}
