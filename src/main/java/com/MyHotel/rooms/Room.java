package com.myhotel.rooms;

import java.util.ArrayList;

public abstract class Room {
    protected String roomType;
    protected String description;
    protected final int roomNumber;
    protected double pricePerNight;
    protected ArrayList<String> amenities;
    protected byte maxOccupancy;
    protected boolean isAvailable;

    public Room(String description, int roomNumber, double pricePerNight, ArrayList<String> amenities, boolean isAvailable) {
        this.description = description;
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.amenities = amenities;
        this.isAvailable = isAvailable;
    }

    public abstract String getRoomType();

    public abstract String getDescription();

    public abstract int getRoomNumber();

    public abstract double getPricePerNight();

    public abstract ArrayList<String> getAmenities();

    public abstract byte getMaxOccupancy();

    public abstract boolean isAvailable();


}