package com.numble.mybox.file.service.command;

import com.numble.mybox.file.controller.request.FileUploadRequest;
import org.springframework.web.multipart.MultipartFile;

public record FileUploadCommand(Long userId, MultipartFile file) {
    public static FileUploadCommand of(FileUploadRequest request) {
        return new FileUploadCommand(request.userId(), request.file());
    }
}
