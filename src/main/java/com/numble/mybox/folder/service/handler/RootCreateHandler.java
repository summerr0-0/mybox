package com.numble.mybox.folder.service.handler;

import com.numble.mybox.common.event.UserJoinedEvent;
import com.numble.mybox.folder.service.FolderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@RequiredArgsConstructor
@Component
public class RootCreateHandler {
    private final FolderService service;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT , classes = UserJoinedEvent.class)
    public void handle(UserJoinedEvent event) {
        log.info("UserJoinedEvent :: RootCreateHandler");
        service.rootCreate(event);
    }
}
