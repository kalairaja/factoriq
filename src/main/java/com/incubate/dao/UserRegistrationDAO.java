package com.incubate.dao;

import com.incubate.model.dto.Address;
import com.incubate.model.dto.User;
import com.incubate.model.dto.UserRegistrationResponse;
import com.incubate.repositary.UserRepository;
import com.incubate.repositary.entity.AddressEntity;
import com.incubate.repositary.entity.UserEntity;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRegistrationDAO {
    private final org.slf4j.Logger logger = LoggerFactory.getLogger(UserRegistrationDAO.class);

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<UserRegistrationResponse> createUser(User user) {

        UserEntity userEntity = null;
        logger.debug("UserRegistrationDAO::createUser::Create new User : {}",user);
        userEntity = mapUserEntity(user);
        userEntity = userRepository.save(userEntity);
        return new ResponseEntity<UserRegistrationResponse>(mapUserDetails(userEntity), HttpStatus.CREATED);
    }

    private UserRegistrationResponse mapUserDetails(UserEntity userEntity){
        UserRegistrationResponse userRegistrationResponse = null;
        if(userEntity!=null){
            userRegistrationResponse = new UserRegistrationResponse();
            userRegistrationResponse.setUserId(Integer.toString(userEntity.getId()));
            userRegistrationResponse.setFirstName(userEntity.getFirstName());
            userRegistrationResponse.setLastName(userEntity.getLastName());
            userRegistrationResponse.setEmail(userEntity.getEmail());
        }
        return userRegistrationResponse;
    }
    private UserEntity mapUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhoneNo(user.getPhoneNo());
//        if(user.getAddress()!=null) {
//            userEntity.setAddress(mapAddressEntity(user.getAddress()));
//        }
        return userEntity;
    }
    private AddressEntity mapAddressEntity(Address address){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress(address.getAddress());
        addressEntity.setAddress1(address.getAddress1());
        addressEntity.setCity(address.getCity());
        addressEntity.setState(address.getState());
        addressEntity.setCounty(address.getCounty());
        addressEntity.setPostcode(address.getPostcode());
        return addressEntity;
    }
}
