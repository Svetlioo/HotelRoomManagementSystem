package com.myhotel.rooms;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AvailableRoomLoading {
    public static void loadRoomsFromJsonToArray(String roomType, ArrayList<Room> arr) {
        try {
            File jsonFile = new File("src/main/java/com/myhotel/rooms/rooms.json");
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonData = objectMapper.readTree(jsonFile);
            for (JsonNode roomData : jsonData) {
                if (roomData.get("roomType").asText().equals(roomType)) {
                    for (JsonNode roomNum : roomData.get("availableRooms")) {
                        Room currentRoom = new Room();
                        currentRoom.setRoomType(roomData.get("roomType").asText());
                        currentRoom.setMaxOccupancy((byte) roomData.get("maxOccupancy").asInt());
                        currentRoom.setDescription(roomData.get("description").asText());
                        currentRoom.setRoomNumber(roomNum.asInt());
                        currentRoom.setPricePerNight(roomData.get("pricePerNight").asDouble());
                        currentRoom.setCancellationFee(roomData.get("cancellationFee").asDouble());
                        currentRoom.setAmenities(convertAmenities(roomData.get("amenities")));
                        currentRoom.setAvailable(true);
                        arr.add(currentRoom);
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<String> convertAmenities(JsonNode amenitiesNode) {
        ArrayList<String> amenities = new ArrayList<>();
        for (JsonNode amenity : amenitiesNode) {
            amenities.add(amenity.asText());
        }
        return amenities;
    }

}
