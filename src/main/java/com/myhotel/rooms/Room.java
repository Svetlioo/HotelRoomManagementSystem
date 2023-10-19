package com.myhotel.rooms;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Room {


    private String roomType;
    private String description;
    private double pricePerNight;
    private double cancellationFee;
    private ArrayList<String> amenities;
    private byte maxOccupancy;
    private int roomNumber;
    private boolean isAvailable;


    public String getRoomType() {
        return roomType;
    }

    public String getDescription() {
        return description;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public double getCancellationFee() {
        return cancellationFee;
    }

    public ArrayList<String> getAmenities() {
        return amenities;
    }

    public byte getMaxOccupancy() {
        return maxOccupancy;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setCancellationFee(double cancellationFee) {
        this.cancellationFee = cancellationFee;
    }

    public void setAmenities(ArrayList<String> amenities) {
        this.amenities = amenities;
    }

    public void setMaxOccupancy(byte maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    @Override
        public String toString() {
            String availability = isAvailable ? "Available" : "Not Available";
            return String.format("""
                    Description: %s
                    Availability: %s
                    Room Type: %s
                    Room Number: %d
                    Price per Night: $%.2f
                    Cancellation Fee: $%.2f
                    Amenities: %s
                    Max Occupancy: %d""", description, availability, roomType, roomNumber, pricePerNight, cancellationFee, amenities, maxOccupancy);
        }


}