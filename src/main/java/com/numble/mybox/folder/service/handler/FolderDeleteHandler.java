package com.numble.mybox.folder.service.handler;

import com.numble.mybox.common.event.FolderDeletedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FolderDeleteHandler {
    @EventListener(FolderDeletedEvent.class)
    public void handle(FolderDeletedEvent event) {

        //event처리
    }
}
