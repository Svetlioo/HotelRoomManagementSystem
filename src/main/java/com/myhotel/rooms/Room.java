package com.myhotel.rooms;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Room {
    protected String roomType;
    protected String description;
    protected int roomNumber;
    protected double pricePerNight;
    protected double cancellationFee;
    protected ArrayList<String> amenities;
    protected byte maxOccupancy;
    protected boolean isAvailable;
    protected Set<String> roomTypes = new HashSet<>();


    public Room(String roomType, int roomNumber) {
        getRoomFromJson(roomType, roomNumber);
    }

    public Room() {

    }

    private void getRoomFromJson(String roomType, int roomNumber) {
        try {
            File jsonFile = new File("src/main/java/com/myhotel/rooms/roooms.json");
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(jsonFile);

            for (JsonNode roomData : jsonData) {
                if (roomData.get("roomType").asText().equals(roomType)) {
                    for (JsonNode roomNum : roomData.get("availableRooms")) {
                        if (roomNum.asInt() == roomNumber) {
                            this.roomType = roomData.get("roomType").asText();
                            this.maxOccupancy = (byte) roomData.get("maxOccupancy").asInt();
                            this.description = roomData.get("description").asText();
                            this.roomNumber = roomNumber;
                            this.pricePerNight = roomData.get("pricePerNight").asDouble();
                            this.cancellationFee = roomData.get("cancellationFee").asDouble();
                            this.amenities = convertAmenities(roomData.get("amenities"));
                            this.isAvailable = false;
                            break;
                        }
                    }

                }
                this.roomTypes.add(roomData.get("roomType").asText());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private ArrayList<String> convertAmenities(JsonNode amenitiesNode) {
        ArrayList<String> amenities = new ArrayList<>();
        for (JsonNode amenity : amenitiesNode) {
            amenities.add(amenity.asText());
        }
        return amenities;
    }

    public abstract String getRoomType();

    public abstract String getDescription();

    public abstract int getRoomNumber();

    public abstract double getPricePerNight();

    public abstract double getCancellationFee();

    public abstract ArrayList<String> getAmenities();

    public abstract byte getMaxOccupancy();

    public abstract boolean isAvailable();

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
                        Max Occupancy: %d
                        """,
                description, availability, roomType, roomNumber, pricePerNight, cancellationFee, amenities, maxOccupancy);
    }


}