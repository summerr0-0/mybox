package com.numble.mybox.user.service.handler;

import com.numble.mybox.common.event.FileUploadedEvent;
import com.numble.mybox.common.event.UserJoinedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UsedStorageIncreaseHandler {
    @EventListener(FileUploadedEvent.class)
    public void handle(FileUploadedEvent event) {

        //event처리
    }

}
