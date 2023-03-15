package com.numble.mybox.user.service.handler;

import com.numble.mybox.common.event.FileDeletedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UsedStorageDecreaseHandler {
    @EventListener(FileDeletedEvent.class)
    public void handle(FileDeletedEvent event) {

        //event처리
    }

}
