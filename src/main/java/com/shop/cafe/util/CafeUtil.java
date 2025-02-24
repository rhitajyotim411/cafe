package com.shop.cafe.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CafeUtil {

    public static final String GENERIC_MSSG = "Something went wrong";
    public static final String INVALID_DATA = "Invalid data";
    public static final String REGISTERED_USER = "An user is already registered with this email";
    public static final String REGISTER_SUCCESS = "User successfully registered";
    public static final String ADMIN_APPRV_WAIT = "Please wait for admin approval to login";

    // Constructor
    private CafeUtil() {
        // prevents object creation
    }

    // Response builder
    public static ResponseEntity<String> getResponseEntity(String mssg, HttpStatus status) {
        return new ResponseEntity<>("{\"message\":\"" + mssg + "\"}", status);
    }
}
