package com.shop.cafe.util;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CafeUtil {

    public static final String GENERIC_MSSG = "Something went wrong";
    public static final String INVALID_DATA = "Invalid data";
    public static final String REGISTERED_USER = "An user is already registered with this email";
    public static final String REGISTER_SUCCESS = "User successfully registered";
    public static final String ADMIN_APPRV_WAIT = "Please wait for admin approval to login";

    // Random String Generator
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    // Constructor
    private CafeUtil() {
        // prevents object creation
    }

    // Response builder
    public static ResponseEntity<String> getResponseEntity(String mssg, HttpStatus status) {
        return new ResponseEntity<>("{\"message\":\"" + mssg + "\"}", status);
    }

    // Random String Generator
    public static String generateRandomString() {
        Random random = new Random();
        int length = random.nextInt(20, 50);
        StringBuilder result = new StringBuilder(length);
        int cxlen = CHARACTERS.length();

        for (int i = 0; i < length; i++) {
            char ch = CHARACTERS.charAt(random.nextInt(cxlen));
            result.append(ch);
        }

        return result.toString();
    }
}
