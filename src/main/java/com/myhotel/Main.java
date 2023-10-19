package com.myhotel;

import com.myhotel.logic.RoomBookingManager;
import com.myhotel.logic.StateManager;


public class Main {
    public static void main(String[] args) {
        StateManager state = new StateManager();
        state.beforeLoginState();
        state.mainMenu();


    }
}


