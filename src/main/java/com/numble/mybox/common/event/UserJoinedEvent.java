package com.numble.mybox.common.event;

import com.numble.mybox.user.service.command.UserCreateCommand;
import lombok.Getter;

@Getter
public class UserJoinedEvent {
    private final String userId;
    private final String name;
    private final String password;

    public static UserJoinedEvent of(UserCreateCommand command) {
        return new UserJoinedEvent(
            command.userId(),
            command.name(),
            command.password());
    }

    public UserJoinedEvent(String userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }
}
