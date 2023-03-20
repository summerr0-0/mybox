package com.numble.mybox.common.event;

import com.numble.mybox.folder.service.command.FolderCreateCommand;
import lombok.Getter;

@Getter
public class FolderCreatedEvent {
    private final Long userId;
    private final Long parentFolderId;

    public static FolderCreatedEvent of(FolderCreateCommand command) {
        return new FolderCreatedEvent(command.userId(), command.parentFolderId());
    }

    private FolderCreatedEvent(Long userId, Long parentFolderId) {
        this.userId = userId;
        this.parentFolderId = parentFolderId;
    }
}
