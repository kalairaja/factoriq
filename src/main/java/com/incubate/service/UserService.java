package com.incubate.service;

import com.incubate.circuit.UserRegistrationCommand;
import com.incubate.dao.UserRegistrationDAO;
import com.incubate.model.dto.User;
import com.incubate.model.dto.UserRegistrationResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rx.Observable;

@Service
public class UserService {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    public UserRegistrationDAO userRegistrationDAO;

    UserRegistrationCommand userRegistrationCommand;
    public Observable<ResponseEntity<UserRegistrationResponse>> createUser(User user) {
        return new UserRegistrationCommand(user,userRegistrationDAO).observe();
    }
}
