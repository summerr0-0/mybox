package com.numble.mybox.file.service.command;

import com.numble.mybox.file.controller.request.FileDeleteRequest;

public record FileDeleteCommand(Long userId, Long fileId) {
    public static FileDeleteCommand of(FileDeleteRequest request) {
        return new FileDeleteCommand(request.userId(), request.fileId());
    }
}