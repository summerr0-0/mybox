package com.numble.mybox.user.service.handler;

import com.numble.mybox.common.event.UserJoinedEvent;
import com.numble.mybox.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserCreateHandler {
    private final UserService service;

    @EventListener(UserJoinedEvent.class)
    @Order(1)
    @TransactionalEventListener
    public void handle(UserJoinedEvent event) {
        log.info("UserJoinedEvent :: RootCreateHandler");
        service.userCreate(event);
    }


}
