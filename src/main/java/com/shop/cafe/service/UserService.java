package com.shop.cafe.service;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shop.cafe.model.Users;
import com.shop.cafe.repository.UserRepository;
import com.shop.cafe.util.CafeUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements UserServiceIntf {

    @Autowired
    UserRepository userRepository;

    private boolean validateSignUpMap(Map<String, String> requestMap) {
        return requestMap.containsKey("name")
                && requestMap.containsKey("contact")
                && requestMap.containsKey("email")
                && requestMap.containsKey("passwd");
    }

    private Users getUserFromMap(Map<String, String> requestMap) {
        Users user = new Users();
        user.setName(requestMap.get("name"));
        user.setContact(requestMap.get("contact"));
        user.setEmail(requestMap.get("email"));
        user.setPasswd(requestMap.get("passwd"));
        user.setStatus(false);
        user.setRole("user");

        return user;
    }

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {

        log.info("Inside signup {}", requestMap);

        try {
            if (validateSignUpMap(requestMap)) {
                Users user = userRepository.findByEmailId(requestMap.get("email"));
                if (Objects.isNull(user)) {
                    userRepository.save(getUserFromMap(requestMap));
                    return CafeUtil.getResponseEntity(CafeUtil.REGISTER_SUCCESS,
                            HttpStatus.OK);
                } else
                    return CafeUtil.getResponseEntity(CafeUtil.REGISTERED_USER,
                            HttpStatus.BAD_REQUEST);
            } else
                return CafeUtil.getResponseEntity(CafeUtil.INVALID_DATA,
                        HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return CafeUtil.getResponseEntity(CafeUtil.GENERIC_MSSG,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
