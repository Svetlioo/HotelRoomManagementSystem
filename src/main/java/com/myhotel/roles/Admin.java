package com.myhotel.roles;

import java.util.ArrayList;

public interface Admin extends User {
    void viewAllBooking();
    void ViewTotalIncome();
    void ViewTotalCancellationFees();
    void AddRoomToJson();
    void ModifyRoomDetails();
    }


