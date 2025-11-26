package assignment;

import java.util.ArrayList;
import java.util.Scanner;

import practice.User;
import practice.exceptions.AuthenticationException;
import practice.exceptions.ExcessiveFailedLoginException;

public class Main {

    private static ArrayList<User> listOfUser = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        initialize();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            String choice = scan.nextLine();

            // INTERAKTIF IF–ELSE (sesuai permintaan)
            if (choice.equals("1")) {
                handleLogin();
            } 
            else if (choice.equals("2")) {
                handleSignUp();
            } 
            else if (choice.equals("3")) {
                System.out.println("Exit program...");
                break;
            } 
            else {
                System.out.println("Invalid choice!");
            }
        }
    }

    // ---------------------------------------------------
    // Initialize default user
    // ---------------------------------------------------
    public static void initialize() {
        User user = new User("admin", "admin");
        listOfUser.add(user);
    }

    // ---------------------------------------------------
    // Login Handler (if user not found -> AuthenticationException)
    // ---------------------------------------------------
    public static void handleLogin() {
        try {
            System.out.print("Username: ");
            String username = scan.nextLine();

            System.out.print("Password: ");
            String password = scan.nextLine();

            boolean success = false;

            for (User u : listOfUser) {
                try {
                    u.login(username, password);
                    System.out.println("Login Success!");
                    success = true;
                    break;

                } catch (AuthenticationException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (!success) {
                throw new AuthenticationException("Login failed for all users!");
            }

        } catch (ExcessiveFailedLoginException e) {
            System.out.println("ERROR: " + e.getMessage());

        } catch (AuthenticationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // ---------------------------------------------------
    // Sign Up Handler
    // ---------------------------------------------------
    public static void handleSignUp() {
        System.out.print("New Username: ");
        String username = scan.nextLine();

        System.out.print("New Password: ");
        String password = scan.nextLine();

        User newUser = new User(username, password);
        listOfUser.add(newUser);

        System.out.println("User registered successfully!");
    }
}
