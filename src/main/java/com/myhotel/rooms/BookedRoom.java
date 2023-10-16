package com.myhotel.rooms;

import java.util.ArrayList;


public class BookedRoom extends Room {
    public BookedRoom(String roomType, int roomNumber) {
        super(roomType, roomNumber);
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
    public double getCancellationFee() {
        return this.cancellationFee;
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
