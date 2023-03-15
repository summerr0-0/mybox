package com.numble.mybox.common.event;

import org.springframework.context.ApplicationEventPublisher;

/**
 * Event 를 발생시킨다
 */
public class Events {
    private static ApplicationEventPublisher publisher;

    static void setPublisher(ApplicationEventPublisher publisher) {
        Events.publisher = publisher;
    }

    public static void raise(Object event) {
        if (publisher != null) {
            publisher.publishEvent(event);
        }
    }
}
