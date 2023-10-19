package com.myhotel.rooms;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RoomManager {
//    private ArrayList<AvailableRoom> rooms = new ArrayList<>();
//    public void loadRooms() {
//        try {
//            File jsonFile = new File("src/main/java/com/myhotel/rooms/rooms.json");
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode jsonData = objectMapper.readTree(jsonFile);
//            for (JsonNode roomData : jsonData) {
//                if (roomData.get("roomType").asText().equals(roomType)) {
//                    for (JsonNode roomNum : roomData.get("availableRooms")) {
//                        if (roomNum.asInt() == roomNumber) {
//                            this.roomType = roomData.get("roomType").asText();
//                            this.maxOccupancy = (byte) roomData.get("maxOccupancy").asInt();
//                            this.description = roomData.get("description").asText();
//                            this.roomNumber = roomNumber;
//                            this.pricePerNight = roomData.get("pricePerNight").asDouble();
//                            this.cancellationFee = roomData.get("cancellationFee").asDouble();
//                            this.amenities = convertAmenities(roomData.get("amenities"));
//                            this.isAvailable = false;
//                            break;
//                        }
//                    }
//
//                }
//                this.roomTypes.add(roomData.get("roomType").asText());
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    }

