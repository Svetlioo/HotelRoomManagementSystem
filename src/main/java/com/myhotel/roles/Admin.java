package com.myhotel.roles;

import java.util.ArrayList;

public class Admin extends Role {

    protected Admin(String name, String password, ArrayList<String> allPermissions) {
        super(name, password, allPermissions);
        permissions.add("View all bookings");
        permissions.add("View total income and total cancellation fees");
        permissions.add("Add or remove rooms or modify room details");
        permissions.add("Book a Room");
        permissions.add("Check availability");
    }
}
