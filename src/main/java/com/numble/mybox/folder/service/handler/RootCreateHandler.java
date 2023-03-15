package com.numble.mybox.folder.service.handler;

import com.numble.mybox.common.event.UserJoinedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RootCreateHandler {
    @EventListener(UserJoinedEvent.class)
    public void handle(UserJoinedEvent event) {

        //event처리
    }
}
