package com.myhotel;

import com.myhotel.roles.User;
import com.myhotel.roles.UserManager;
import com.myhotel.rooms.BookedRoom;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println("Room Booking System Menu:");
        System.out.printf("Current user %s%n", currentUser.getUsername());
        while (true) {
            System.out.println("1. View Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Check Availability");
            System.out.println("5. View Booked Rooms");
            System.out.println("6. Update Booking");
            System.out.println("7. View Booking Details");
            System.out.println("8. Exit");
            System.out.println("9. Help");
            System.out.print("Enter your choice (1-9): ");
            int input = Integer.parseInt(sc.nextLine());
            if (input == 9) {
                break;
            }
            switch (input) {
                case 1:
                    if (currentUser.getPermissions().contains("Check availability")) {
                    }
                    break;
                case 2:
                    // Book a Room

                    break;
                case 3:
                    // Cancel Booking

                    break;
                case 4:
                    // Check Availability

                    break;
                case 5:
                    // View Booked Rooms

                    break;
                case 6:
                    // Update Booking

                    break;
                case 7:
                    // View Booking Details

                    break;
                case 8:
                    // Exit the program
                    break;
                case 9:
                    System.out.println("Exiting Room Booking System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 9.");
            }
        }
    }
}


