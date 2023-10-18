package com.myhotel.menu;

public class HelperMethods {
    public static void showUserChoices() {
        System.out.println("""
                1. View Rooms
                2. Book a Room
                3. Cancel Booking
                4. Check Availability
                5. View Booked Rooms
                6. Update Booking
                7. View Booking Details
                8. Logout
                9. Exit program
                Enter your choice (1-9):""");
    }

    public static void showLoginChoices() {
        System.out.println("""
                Press 1 for Login
                Press 2 for Register""");
    }

}
