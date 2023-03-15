package com.numble.mybox.file.service;

import com.numble.mybox.common.event.Events;
import com.numble.mybox.common.event.FileUploadedEvent;
import com.numble.mybox.file.service.command.FileUploadCommand;
import com.numble.mybox.file.service.exception.FullStorageException;
import com.numble.mybox.user.service.UserService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(readOnly = true)
@NoArgsConstructor
public class FileService {

    UserService userService;

    @Transactional
    public void fileUpload(FileUploadCommand command) {
        if (userService.isFull(command.userId())) {
            throw new FullStorageException();
        }
        Events.raise(new FileUploadedEvent(command));
    }


}
