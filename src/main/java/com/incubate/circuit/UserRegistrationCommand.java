package com.incubate.circuit;

import com.incubate.dao.UserRegistrationDAO;
import com.incubate.model.dto.User;
import com.incubate.model.dto.UserRegistrationResponse;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.http.ResponseEntity;

public class UserRegistrationCommand extends HystrixCommand<ResponseEntity<UserRegistrationResponse>> {
    private final UserRegistrationDAO userRegistrationDAO;
        private final User user;

        public UserRegistrationCommand(User user, UserRegistrationDAO userRegistrationDAO) {
            super(HystrixCommandGroupKey.Factory.asKey("UserRegistrationCommand"));
            this.user = user;
            this.userRegistrationDAO = userRegistrationDAO;
        }

        @Override
        protected ResponseEntity<UserRegistrationResponse> run() throws Exception {
            return userRegistrationDAO.createUser(user);
        }
}
