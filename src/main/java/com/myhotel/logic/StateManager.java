package com.myhotel.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.myhotel.menu.HelperMethods;
import com.myhotel.roles.Role;
import com.myhotel.roles.User;
import com.myhotel.rooms.Room;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StateManager {
    private static final ArrayList<User> users = new ArrayList<>();
    private User currentUser;


    private static void loadUserProfiles() {
        users.clear();
        try {
            File jsonFile = new File("src/main/java/com/myhotel/roles/users.json");
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(jsonFile);
            JsonNode usersArray = jsonData.get("users");
            for (JsonNode user : usersArray) {
                users.add(new Role(user.get("username").asText(), user.get("password").asText()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String registerUser(String username, String password) {
        boolean isNotRegistered = true;
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                isNotRegistered = false;
                break;
            }
            if (user.getUsername().equals(username) && !user.getPassword().equals(password)) {
                return "Username already in use";
            }
        }
        if (isNotRegistered) {
            User user = new Role(username, password);
            users.add(user);
            saveUserProfile(user);
            return "Registered successfully";
        }
        return "Already registered";
    }

    private void saveUserProfile(User user) {
        try {
            File jsonFile = new File("src/main/java/com/myhotel/roles/users.json");
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode jsonData = objectMapper.readValue(jsonFile, ObjectNode.class);
            ArrayNode usersArray = (ArrayNode) jsonData.get("users");
            if (usersArray == null) {
                usersArray = objectMapper.createArrayNode();
                jsonData.set("users", usersArray);
            }
            ObjectNode userNode = objectMapper.createObjectNode();
            userNode.put("username", user.getUsername());
            userNode.put("password", user.getPassword());
            usersArray.add(userNode);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, jsonData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private User loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public StateManager() {
        this.currentUser = null;
    }

    public void beforeLoginState() {

//        System.out.println("Hello world!");
//        BookedRoom room = new BookedRoom("RoomDeluxe", 103);
//        System.out.println(room);
//        System.out.println("Welcome to my hotel management system!");
        Scanner sc = new Scanner(System.in);
        loadUserProfiles();
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            HelperMethods.showLoginChoices();
            String input = sc.nextLine();
            if (input.equals("1")) {
                System.out.println("Enter username:");
                String username = sc.nextLine();
                System.out.println("Enter password:");
                String password = sc.nextLine();
                this.currentUser = loginUser(username, password);
                if (this.currentUser != null) {
                    isLoggedIn = true;
                    System.out.printf("Successfully logged in as user %s%n", username);
                } else {
                    System.out.println("Incorrect username or password. Try again!");
                }
            } else if (input.equals("2")) {
                System.out.println("Enter username:");
                String username = sc.nextLine();
                System.out.println("Enter password:");
                String password = sc.nextLine();
                String successfulRegistry = registerUser(username, password);
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

    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Room Booking System Menu:");
        System.out.printf("Current user %s%n", currentUser.getUsername());
        while (true) {
            HelperMethods.showUserChoices();
            String input = sc.nextLine();
            if (input.equals("0")) {
                System.out.println("Exiting Room Booking System. Goodbye!");
                System.exit(0);
                break;
            }
            RoomBookingManager roombookingmanager = new RoomBookingManager();
            roombookingmanager.loadAllRoomsToArrays();

            switch (input) {
                case "1" -> {
                    roombookingmanager.displayAvailableRooms();
                    System.out.println("Press 0 to go back to main menu!");
                    String goBack = sc.nextLine();
                    while (!goBack.equals("0")) {
                        System.out.println("Press 0 to go back to main menu!");
                    }
                }
                case "2" -> {
                    roombookingmanager.bookARoom(currentUser);
                    System.out.println(currentUser.getHistoryOfBookings().get(0).toString());
                    System.out.println("Press 0 to go back to main menu!");
                    String goBack = sc.nextLine();
                    while (!goBack.equals("0")) {
                        System.out.println("Press 0 to go back to main menu!");
                    }
                }
                case "3" -> {

                }
                case "4" -> {

                }
                case "5" -> {

                }
                case "6" -> {

                }
                case "7" -> {
                    int roomNum = 1;
                    for (Room room : currentUser.getHistoryOfBookings()) {
                        System.out.printf("Booked room number %d information: %n", roomNum++);
                        System.out.println(room.toString());
                    }
                    System.out.println("Press 0 to go back to main menu!");
                    String goBack = sc.nextLine();
                    while (!goBack.equals("0")) {
                        System.out.println("Press 0 to go back to main menu!");
                    }
                }
                case "8" -> {
                    this.currentUser = null;
                    beforeLoginState();
                }
                case "9" -> {

                }
                default -> System.out.println("Invalid choice. Please enter a number from 1 to 9.");

            }
        }
    }
}

