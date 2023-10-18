package com.myhotel.roles;

import java.util.ArrayList;
import java.util.Set;

public interface User {
    void bookRoom();

    void checkAvailability();

    String getUsername();

    String getPassword();

    String registerUser(String username, String password);

    boolean loginUser(String username, String password)

    ArrayList<String> getHistoryOfBookings();

    void addNewBookingToHistory(String BookingInfo);

    void saveUserProfile(User user);

}
