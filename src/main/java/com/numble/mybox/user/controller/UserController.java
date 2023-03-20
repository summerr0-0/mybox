package com.numble.mybox.user.controller;

import com.numble.mybox.common.controller.response.EmptyResponse;
import com.numble.mybox.user.controller.request.UserCreateRequest;
import com.numble.mybox.user.service.UserService;
import com.numble.mybox.user.service.command.UserCreateCommand;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmptyResponse createUser(@RequestBody @Valid UserCreateRequest request) {
        service.join(UserCreateCommand.of(request));
        return new EmptyResponse.Ok<>();
    }
}
