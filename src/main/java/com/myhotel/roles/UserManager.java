package com.myhotel.roles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UserManager {
    private Set<User> users = new HashSet<>();

    private String path = "src/main/java/com/myhotel/roles/users.json";

    public void loadUserProfiles() {
        this.users.clear();
        try {
            File jsonFile = new File(path);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(jsonFile);
            JsonNode usersArray = jsonData.get("users");
            for (JsonNode user : usersArray) {
                ArrayList<String> permissions = new ArrayList<>();
                for (JsonNode permission : user.get("permissions")) {
                    permissions.add(permission.asText());
                }
                this.users.add(new User(user.get("username").asText(), user.get("password").asText(), permissions));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveUserProfiles() {
        try {
            File jsonFile = new File(path);
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode jsonData = objectMapper.createObjectNode();
            ArrayNode usersArray = objectMapper.createArrayNode();

            System.out.println(this.users.size());
            for (User user : this.users) {
                ObjectNode userNode = objectMapper.createObjectNode();
                userNode.put("username", user.getUsername());
                userNode.put("password", user.getPassword());

                ArrayNode permissionsArray = objectMapper.createArrayNode();
                for (String permission : user.getPermissions()) {
                    permissionsArray.add(permission);
                }
                userNode.set("permissions", permissionsArray);

                usersArray.add(userNode);
            }
            jsonData.set("users", usersArray);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, jsonData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String registerUser(String username, String password) {
        boolean isNotRegistered = true;
        for (User user : this.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                isNotRegistered = false;
                break;
            }
            if (user.getUsername().equals(username) && !user.getPassword().equals(password)) {
                return "Username already in use";
            }
        }


        if (isNotRegistered) {
            this.users.add(new User(username, password, new ArrayList<>()));
            saveUserProfiles();
            return "Registered successfully";
        }
        return "Already registered";
    }

    public User loginUser(String username, String password) {
        for (User user : this.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void viewUserProfile(User user) {
        System.out.println(user.getUsername() + ":");
        System.out.println(user.getHistoryOfBookings());
    }
}

