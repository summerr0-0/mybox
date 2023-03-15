package com.numble.mybox.file.service.handler;

import com.numble.mybox.common.event.FileUploadedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FileUploadHandler {
    @EventListener(FileUploadedEvent.class)
    public void handle(FileUploadedEvent event) {

        //event처리
    }

}
