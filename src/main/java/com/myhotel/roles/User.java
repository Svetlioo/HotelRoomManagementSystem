package com.myhotel.roles;

import java.util.ArrayList;

public class User extends Role {
    protected User(String name, String password, ArrayList<String> allPermissions) {
        super(name, password, allPermissions);
        permissions.add("Book a Room");
        permissions.add("Check availability");
    }
}
