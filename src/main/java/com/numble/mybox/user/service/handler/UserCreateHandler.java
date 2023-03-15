package com.numble.mybox.user.service.handler;

import com.numble.mybox.common.event.UserJoinedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreateHandler {

    @EventListener(UserJoinedEvent.class)
    public void handle(UserJoinedEvent event) {

        //event처리
    }


}
