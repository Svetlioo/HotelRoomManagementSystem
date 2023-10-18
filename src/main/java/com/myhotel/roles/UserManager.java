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







    public void viewUserProfile(User user) {
        System.out.println(user.getUsername() + ":");
        System.out.println(user.getHistoryOfBookings());
    }
}

