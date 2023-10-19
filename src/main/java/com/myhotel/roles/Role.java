package com.myhotel.roles;

import com.myhotel.rooms.Room;

import java.util.ArrayList;

public class Role implements User, Admin {
    private final String userName;
    private final String password;
    private final ArrayList<Room> historyOfBookings;

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
    public ArrayList<Room> getHistoryOfBookings() {
        return this.historyOfBookings;
    }


    @Override
    public void addNewBookingToHistory(Room BookingInfo) {
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
