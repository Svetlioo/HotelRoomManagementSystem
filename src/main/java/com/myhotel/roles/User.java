package com.myhotel.roles;

import java.util.ArrayList;
import java.util.Set;

public interface User {

    void bookRoom();

    void checkAvailability();

    String getUsername();

    String getPassword();

    ArrayList<String> getHistoryOfBookings();

    void addNewBookingToHistory(String BookingInfo);


}
