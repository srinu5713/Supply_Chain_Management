// UserFactory.java
package com.sc.sc.factory;

import com.sc.sc.model.User;
import com.sc.sc.model.Role;

public class UserFactory {
    public static User createUser(String username, String password, Role type, String address, String mobileNumber) {
        return new User(username, password, type, address, mobileNumber);
    }
}
