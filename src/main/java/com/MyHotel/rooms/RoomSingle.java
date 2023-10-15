package com.myhotel.rooms;

import java.util.ArrayList;


public class RoomSingle extends Room {
    String roomType = "Single Room";
    byte maxOccupancy = 2;

    public RoomSingle(String description, int roomNumber, double pricePerNight, ArrayList<String> amenities, boolean isAvailable) {
        super(description, roomNumber, pricePerNight, amenities, isAvailable);
    }

    @Override
    public String getRoomType() {
        return this.roomType;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public int getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public double getPricePerNight() {
        return this.pricePerNight;
    }

    @Override
    public ArrayList<String> getAmenities() {
        return this.amenities;
    }

    @Override
    public byte getMaxOccupancy() {
        return this.maxOccupancy;
    }

    @Override
    public boolean isAvailable() {
        return this.isAvailable;
    }

}
