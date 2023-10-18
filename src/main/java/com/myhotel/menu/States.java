package com.myhotel.menu;

import com.myhotel.roles.User;
import com.myhotel.roles.UserManager;
import com.myhotel.rooms.BookedRoom;

import java.util.Scanner;

public class States {
    public void BeforeLoginState() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Hello world!");
        BookedRoom room = new BookedRoom("RoomDeluxe", 103);
        System.out.println(room);

        System.out.println("Welcome to my hotel management system!");
        UserManager manager = new UserManager();
        User currentUser = null;
        manager.loadUserProfiles();
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            System.out.println("Press 1 for Login");
            System.out.println("Press 2 for Register");
            String input = sc.nextLine();
            if (input.equals("1")) {
                System.out.println("Enter username:");
                String username = sc.nextLine();
                System.out.println("Enter password:");
                String password = sc.nextLine();
                currentUser = manager.loginUser(username, password);
                if (currentUser != null) {
                    isLoggedIn = true;
                    System.out.printf("Successfully logged in as user %s%n", username);
                } else {
                    System.out.println("No such user. Try again!");
                }
            } else if (input.equals("2")) {
                System.out.println("Enter username:");
                String username = sc.nextLine();
                System.out.println("Enter password:");
                String password = sc.nextLine();
                String successfulRegistry = manager.registerUser(username, password);
                if (successfulRegistry.equals("Registered successfully")) {
                    System.out.printf("User %s registered successfully. Login to book a room!%n", username);
                }
                if (successfulRegistry.equals("Already registered")) {
                    System.out.printf("User %s is already registered. Login to book a room!%n", username);
                }
                if (successfulRegistry.equals("Username already in use")) {
                    System.out.printf("Username %s is already in use. Use different username!%n", username);
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
