package com.numble.mybox.folder.service.handler;

import com.numble.mybox.common.event.FolderCreatedEvent;
import com.numble.mybox.folder.service.FolderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FolderCreateHandler {
    FolderService service;
    @EventListener(FolderCreatedEvent.class)
    public void handle(FolderCreatedEvent event) {
        log.info("FolderCreatedEvent :: FolderCreateHandler");

    }
}
