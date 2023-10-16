package com.myhotel.roles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Role {
    protected Set<String> permissions = new HashSet<>();
    private final String userName;
    private final String password;
    private final ArrayList<String> historyOfBookings;

    protected Role(String name, String password, ArrayList<String> allPermissions) {
        this.userName = name;
        this.password = password;
        this.permissions.addAll(allPermissions);
        this.historyOfBookings = new ArrayList<>();
    }

    public String getUsername() {
        return this.userName;
    }

    String getPassword() {
        return this.password;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public ArrayList<String> getHistoryOfBookings() {
        return historyOfBookings;
    }

    public void addNewBookingToHistory(String BookingInfo) {
        this.historyOfBookings.add(BookingInfo);
    }

}
