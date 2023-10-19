package com.myhotel.logic;

import com.myhotel.roles.User;
import com.myhotel.rooms.AvailableRoomLoading;
import com.myhotel.rooms.Room;


import java.util.ArrayList;
import java.util.Scanner;

public class RoomBookingManager {
    private final ArrayList<Room> singleRoomsArr;
    private final ArrayList<Room> deluxeRoomsArr;
    private final ArrayList<Room> suiteRoomsArr;
    private final ArrayList<Room> standardRoomsArr;
    private final ArrayList<Room> doubleRoomsArr;
    private final ArrayList<Room> executiveRoomsArr;

    private final ArrayList<String> typeOfRooms;

    public RoomBookingManager() {
        this.singleRoomsArr = new ArrayList<>();
        this.deluxeRoomsArr = new ArrayList<>();
        this.suiteRoomsArr = new ArrayList<>();
        this.standardRoomsArr = new ArrayList<>();
        this.doubleRoomsArr = new ArrayList<>();
        this.executiveRoomsArr = new ArrayList<>();
        this.typeOfRooms = new ArrayList<>();
        this.typeOfRooms.add("RoomSingle");
        this.typeOfRooms.add("RoomDouble");
        this.typeOfRooms.add("RoomStandard");
        this.typeOfRooms.add("RoomSuite");
        this.typeOfRooms.add("RoomDeluxe");
        this.typeOfRooms.add("RoomExecutive");
    }

    public void loadAllRoomsToArrays() {
        AvailableRoomLoading.loadRoomsFromJsonToArray("RoomSingle", singleRoomsArr);
        AvailableRoomLoading.loadRoomsFromJsonToArray("RoomDouble", doubleRoomsArr);
        AvailableRoomLoading.loadRoomsFromJsonToArray("RoomStandard", standardRoomsArr);
        AvailableRoomLoading.loadRoomsFromJsonToArray("RoomSuite", suiteRoomsArr);
        AvailableRoomLoading.loadRoomsFromJsonToArray("RoomDeluxe", deluxeRoomsArr);
        AvailableRoomLoading.loadRoomsFromJsonToArray("RoomExecutive", executiveRoomsArr);
    }

    public void displayAvailableRooms() {
        displayAvailableRoomsFromType(singleRoomsArr);
        displayAvailableRoomsFromType(doubleRoomsArr);
        displayAvailableRoomsFromType(standardRoomsArr);
        displayAvailableRoomsFromType(suiteRoomsArr);
        displayAvailableRoomsFromType(deluxeRoomsArr);
        displayAvailableRoomsFromType(executiveRoomsArr);
    }

    public void displayAvailableRoomsFromType(ArrayList<Room> roomArr) {
        if (roomArr.isEmpty()) {
            return;
        }
        Room firstRoom = roomArr.get(0);
        System.out.printf("""
                Room Type: %s
                Description: %s
                Price per Night: $%.2f
                Cancellation Fee: $%.2f
                Amenities: %s
                Max Occupancy: %d%n""", firstRoom.getRoomType(), firstRoom.getDescription(), firstRoom.getPricePerNight(), firstRoom.getCancellationFee(), firstRoom.getAmenities(), firstRoom.getMaxOccupancy());

        displayAvailableRoomNumbers(roomArr);
        System.out.println();
        System.out.println("==========================================================================================");
    }

    public void displayAvailableRoomNumbers(ArrayList<Room> roomArr) {
        System.out.print("Available rooms: ");
        for (int i = 0; i < roomArr.size(); i++) {
            System.out.print(roomArr.get(i).getRoomNumber());
            if (i != roomArr.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    public ArrayList<Integer> getRoomNumbersToList(ArrayList<Room> roomArr) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < roomArr.size(); i++) {
            arr.add(roomArr.get(i).getRoomNumber());
        }
        return arr;
    }

    private Room getRoomFromArray(ArrayList<Room> arr, int roomNum) {
        for (Room room : arr) {
            if (room.getRoomNumber() == roomNum) return room;
        }
        return null;
    }

    public void bookARoom(User currentUser) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter type of room");
        for (int i = 1; i <= typeOfRooms.size(); i++) {
            System.out.printf("Press %d for %s%n", i, typeOfRooms.get(i - 1));
        }
        String selectedType = sc.nextLine();
        switch (selectedType) {
            case "1", "2", "3", "4", "5", "6" -> selectedType = typeOfRooms.get(Integer.parseInt(selectedType) - 1);
            default -> {
                System.out.println("Invalid input");
                selectedType = sc.nextLine();
            }
        }
        ArrayList<Integer> currentArray = new ArrayList<>();

        switch (selectedType) {
            case "RoomStandard":
                displayAvailableRoomNumbers(standardRoomsArr);
                currentArray.addAll(getRoomNumbersToList(standardRoomsArr));
                break;
            case "RoomSuite":
                displayAvailableRoomNumbers(suiteRoomsArr);
                currentArray.addAll(getRoomNumbersToList(suiteRoomsArr));
                break;
            case "RoomDeluxe":
                displayAvailableRoomNumbers(deluxeRoomsArr);
                currentArray.addAll(getRoomNumbersToList(deluxeRoomsArr));
                break;
            case "RoomSingle":
                displayAvailableRoomNumbers(singleRoomsArr);
                currentArray.addAll(getRoomNumbersToList(singleRoomsArr));
                break;
            case "RoomDouble":
                displayAvailableRoomNumbers(doubleRoomsArr);
                currentArray.addAll(getRoomNumbersToList(doubleRoomsArr));
                break;
            case "RoomExecutive":
                displayAvailableRoomNumbers(executiveRoomsArr);
                currentArray.addAll(getRoomNumbersToList(executiveRoomsArr));
                break;
        }
        System.out.println();
        Room bookedRoom = null;
        System.out.println("Enter which room you want to book: ");
        int roomNumInput = Integer.parseInt(sc.nextLine());
        while (!currentArray.contains(roomNumInput)) {
            System.out.println("Enter a valid room number!");
            roomNumInput = sc.nextInt();
        }
        switch (selectedType) {
            case "RoomStandard":
                bookedRoom = getRoomFromArray(standardRoomsArr, roomNumInput);
                break;
            case "RoomSuite":
                bookedRoom = getRoomFromArray(suiteRoomsArr, roomNumInput);
                break;
            case "RoomDeluxe":
                bookedRoom = getRoomFromArray(deluxeRoomsArr, roomNumInput);
                break;
            case "RoomSingle":
                bookedRoom = getRoomFromArray(singleRoomsArr, roomNumInput);
                break;
            case "RoomDouble":
                bookedRoom = getRoomFromArray(doubleRoomsArr, roomNumInput);
                break;
            case "RoomExecutive":
                bookedRoom = getRoomFromArray(executiveRoomsArr, roomNumInput);
                ;
                break;
        }

        if (bookedRoom != null) {
            System.out.println("Room booked successfully!");
            bookedRoom.setAvailable(false);
            currentUser.addNewBookingToHistory(bookedRoom);
        }

        // Bad code, I know, I can not find a better solution for now.


    }


}
