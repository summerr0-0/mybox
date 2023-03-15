package com.numble.mybox.common.event;

import com.numble.mybox.file.service.command.FileDeleteCommand;
import lombok.Getter;

@Getter
public class FileDeletedEvent {

    private final Long userId;
    private final Long fileId;
    public FileDeletedEvent(FileDeleteCommand command) {
        userId = command.userId();
        fileId = command.fileId();
    }
}
