package com.myhotel.roles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Role implements User, Admin {
    private final String userName;
    private final String password;
    private final ArrayList<String> historyOfBookings;

    protected Role(String name, String password) {
        this.userName = name;
        this.password = password;
        this.historyOfBookings = new ArrayList<>();
    }

    private static final ArrayList<User> users = new ArrayList<>();


    public static void loadUserProfiles() {
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

    @Override
    public void saveUserProfile(User user) {
        try {
            File jsonFile = new File("src/main/java/com/myhotel/roles/users.json");
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode jsonData = objectMapper.createObjectNode();
            ArrayNode usersArray = objectMapper.createArrayNode();
            ObjectNode userNode = objectMapper.createObjectNode();
            userNode.put("username", user.getUsername());
            userNode.put("password", user.getPassword());
            usersArray.add(userNode);
            jsonData.set("users", usersArray);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, jsonData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String registerUser(String username, String password) {
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
            this.saveUserProfile(user);
            return "Registered successfully";
        }
        return "Already registered";
    }

    @Override
    public boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void bookRoom() {

    }

    @Override
    public void checkAvailability() {

    }

    @Override
    public ArrayList<String> getHistoryOfBookings() {
        return this.historyOfBookings;
    }

    @Override
    public void addNewBookingToHistory(String BookingInfo) {
        this.historyOfBookings.add(BookingInfo);
    }

    @Override
    public void viewAllBooking() {
        for (int i = 0; i < this.historyOfBookings.size(); i++) {
            System.out.println(historyOfBookings.get(i));
        }
    }

    @Override
    public void ViewTotalIncome() {

    }

    @Override
    public void ViewTotalCancellationFees() {

    }

    @Override
    public void AddRoomToJson() {

    }

    @Override
    public void ModifyRoomDetails() {

    }

    public String getUsername() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }


}
