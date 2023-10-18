package com.myhotel;

import com.myhotel.Logic.StateManager;
import com.myhotel.roles.User;
import com.myhotel.roles.UserManager;
import com.myhotel.rooms.BookedRoom;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        StateManager state = new StateManager();
        state.BeforeLoginState();
        state.mainMenu();

    }
}


