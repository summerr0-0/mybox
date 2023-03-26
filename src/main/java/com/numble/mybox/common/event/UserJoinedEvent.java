package com.numble.mybox.common.event;

import com.numble.mybox.user.service.command.UserCreateCommand;
import lombok.Getter;

@Getter
public class UserJoinedEvent {
    private final Long id;
    private final String name;
    private final String password;

    public static UserJoinedEvent of(Long id, UserCreateCommand command) {
        return new UserJoinedEvent(
            id,
            command.name(),
            command.password());
    }

    public UserJoinedEvent(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
