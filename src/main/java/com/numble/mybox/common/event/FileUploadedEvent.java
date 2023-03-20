package com.numble.mybox.common.event;

import com.numble.mybox.file.service.command.FileUploadCommand;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;
@Getter
public class FileUploadedEvent {
    private final Long userId;
    private final Long folderId;
    private final MultipartFile file;

    public FileUploadedEvent(FileUploadCommand command) {
        userId = command.userId();
        folderId = command.folderId();
        file = command.file();
    }

}
