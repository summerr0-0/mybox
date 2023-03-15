package com.numble.mybox.file.service.handler;

import com.numble.mybox.common.event.FileDeletedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FileDeleteHandler {
    @EventListener(FileDeletedEvent.class)
    public void handle(FileDeletedEvent event) {

        //event처리
    }

}
