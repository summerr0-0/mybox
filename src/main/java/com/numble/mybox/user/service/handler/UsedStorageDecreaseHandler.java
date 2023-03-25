package com.numble.mybox.user.service.handler;

import com.numble.mybox.common.event.FileDeletedEvent;
import com.numble.mybox.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UsedStorageDecreaseHandler {
    private final UserService service;

    @EventListener(FileDeletedEvent.class)
    public void handle(FileDeletedEvent event) {
        log.info("FileDeletedEvent :: UsedStorageDecreaseHandler start");

        service.updateStorage(event.getUserId(), event.getFile().getSize() * -1);
    }

}
