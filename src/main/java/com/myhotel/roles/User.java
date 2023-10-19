package com.myhotel.roles;

import com.myhotel.rooms.Room;

import java.util.ArrayList;
import java.util.Set;

public interface User {

    void bookRoom();

    void checkAvailability();

    void addNewBookingToHistory(Room BookingInfo);

    String getUsername();

    String getPassword();

    ArrayList<Room> getHistoryOfBookings();



}
