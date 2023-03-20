package com.numble.mybox.folder.service.command;

import com.numble.mybox.folder.controller.request.FolderCreateRequest;

public record FolderCreateCommand(Long userId, Long parentFolderId) {
    public static FolderCreateCommand of(FolderCreateRequest request) {
        return new FolderCreateCommand(request.userId(), request.parentFolderId());
    }
}
