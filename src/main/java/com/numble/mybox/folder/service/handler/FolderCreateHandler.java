package com.numble.mybox.folder.service.handler;

import com.numble.mybox.common.event.FileDeletedEvent;
import com.numble.mybox.common.event.FolderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FolderCreateHandler {
    @EventListener(FolderCreatedEvent.class)
    public void handle(FolderCreatedEvent event) {

        //event처리
    }
}
