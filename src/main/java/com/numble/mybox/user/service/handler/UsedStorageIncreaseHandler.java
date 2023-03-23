package com.numble.mybox.user.service.handler;

import com.numble.mybox.common.event.FileUploadedEvent;
import com.numble.mybox.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Slf4j
@RequiredArgsConstructor
@Component
public class UsedStorageIncreaseHandler {
    private final UserService userService;
    @EventListener(FileUploadedEvent.class)
    public void handle(FileUploadedEvent event) {
        log.info("FileUploadedEvent :: UsedStorageIncreaseHandler start");

        //event처리
        userService.useStorage(event.getUserId(), event.getFile().getSize());
    }

}
