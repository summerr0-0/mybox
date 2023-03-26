package com.numble.mybox.file.service.command;

import com.numble.mybox.file.controller.request.FileGetRequest;

public record FileDownloadCommand(Long userId, Long fileId) {
    public static FileDownloadCommand of(FileGetRequest request) {
        return new FileDownloadCommand(request.userId(), request.fileId());
    }
}