package com.myhotel.rooms;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AvailableRoom extends Room {
    public AvailableRoom(String roomType, int roomNumber) {
        super(roomType, roomNumber);
        this.isAvailable = true;
    }


    private ArrayList<String> convertAmenities(JsonNode amenitiesNode) {
        ArrayList<String> amenities = new ArrayList<>();
        for (JsonNode amenity : amenitiesNode) {
            amenities.add(amenity.asText());
        }
        return amenities;
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
