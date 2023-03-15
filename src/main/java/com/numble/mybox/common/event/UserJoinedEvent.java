package com.numble.mybox.common.event;

import lombok.Getter;

@Getter
public class UserJoinedEvent {
    private final String userId;
    private final String userName;

    public static UserJoinedEvent of(String userId, String userName) {
        return new UserJoinedEvent(userId, userName);
    }

    private UserJoinedEvent(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
