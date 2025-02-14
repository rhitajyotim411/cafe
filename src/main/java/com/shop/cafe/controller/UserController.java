package com.shop.cafe.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.shop.cafe.service.UserServiceIntf;
import com.shop.cafe.util.CafeUtil;

@RestController
public class UserController implements UserControllerIntf {

    @Autowired
    UserServiceIntf userService;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            return userService.signUp(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return CafeUtil.getResponseEntity(CafeUtil.GENERIC_MSSG,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
