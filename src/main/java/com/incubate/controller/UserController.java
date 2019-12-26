package com.incubate.controller;

        import com.incubate.model.dto.User;
        import com.incubate.model.dto.UserRegistrationResponse;
        import com.incubate.service.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.MediaType;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.context.request.async.DeferredResult;
        import rx.Observable;

        import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping(value = "/api/user/registration", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {
            MediaType.APPLICATION_JSON_VALUE})
    public DeferredResult<ResponseEntity<UserRegistrationResponse>> createUser(@RequestHeader("X-CLIENT-ID") String clientId,
                                                                               @Valid @RequestBody User user) {
        DeferredResult<ResponseEntity<UserRegistrationResponse>> deferredResult = new DeferredResult<>();
        Observable<ResponseEntity<UserRegistrationResponse>> o = userService.createUser(user);
        o.subscribe(deferredResult::setResult, deferredResult::setErrorResult);
        return deferredResult;
    }

}
