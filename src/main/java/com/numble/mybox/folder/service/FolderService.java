package com.numble.mybox.folder.service;

import com.numble.mybox.common.event.Events;
import com.numble.mybox.common.event.FolderCreatedEvent;
import com.numble.mybox.folder.service.command.FolderCreateCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FolderService {
    public void createFolder(FolderCreateCommand command) {
        Events.raise(FolderCreatedEvent.of(command));
    }
}
