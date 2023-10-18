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

    public Role(String name, String password) {
        this.userName = name;
        this.password = password;
        this.historyOfBookings = new ArrayList<>();
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
