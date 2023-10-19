package com.myhotel.rooms;

import com.myhotel.rooms.Room;
import com.myhotel.rooms.roomTypes.*;

import java.util.HashSet;
import java.util.Set;

public class RoomFactory {

    public static Room createRoom(String roomType) {
        switch (roomType) {
            case "StandardRoom":
                return new RoomStandard();
            case "SuiteRoom":
                return new RoomSuite();
            case "DeluxeRoom":
                return new RoomDeluxe();
            case "SingleRoom":
                return new RoomSingle();
            case "DoubleRoom":
                return new RoomDouble();
            case "ExecutiveRoom":
                return new RoomExecutive();
            default:
                throw new IllegalArgumentException("Unsupported room type: " + roomType);
        }
    }

}
