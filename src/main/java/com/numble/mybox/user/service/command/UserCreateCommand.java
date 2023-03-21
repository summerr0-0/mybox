package com.numble.mybox.user.service.command;


import com.numble.mybox.user.controller.request.UserCreateRequest;

public record UserCreateCommand(String userId, String name, String password) {
    public static UserCreateCommand of(UserCreateRequest request) {
        return new UserCreateCommand(request.userId(), request.name(), request.password());
    }
}
