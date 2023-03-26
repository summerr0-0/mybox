package com.numble.mybox.file.service;

import com.numble.mybox.common.event.Events;
import com.numble.mybox.common.event.FileDeletedEvent;
import com.numble.mybox.common.event.FileUploadedEvent;
import com.numble.mybox.file.domain.File;
import com.numble.mybox.file.infra.FileProcessService;
import com.numble.mybox.file.infra.repository.FileRepository;
import com.numble.mybox.file.service.command.FileDeleteCommand;
import com.numble.mybox.file.service.command.FileDownloadCommand;
import com.numble.mybox.file.service.command.FileUploadCommand;
import com.numble.mybox.file.service.exception.FileNotFoundException;
import com.numble.mybox.file.service.exception.FullStorageException;
import com.numble.mybox.user.service.UserService;
import com.numble.mybox.user.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FileService {
    private final UserService userService;
    private final FileRepository fileRepository;
    private final FileProcessService fileProcessService;

    @Transactional
    public void fileUpload(FileUploadCommand command) {
        //todo security 적용하면 변경해야 한다
        if (!userService.isExistUser(command.userId())) throw new UserNotFoundException();
        if (userService.isFull(command.userId())) throw new FullStorageException();
        String resultUrl = fileProcessService.uploadFile(command.file(), command.userId());
        fileRepository.save(File.of(command.userId(),
            command.file().getName(),
            resultUrl,
            command.folderId(),
            command.file().getSize()
        ));
        Events.raise(new FileUploadedEvent(command));
    }

    @Transactional
    public void fileDelete(FileDeleteCommand command) {
        //todo security 적용하면 변경해야 한다
        if (!userService.isExistUser(command.userId())) throw new UserNotFoundException();
        File file = fileRepository.findById(command.fileId())
            .orElseThrow(FileNotFoundException::new);
        fileProcessService.deleteFile(file.getName());
        file.deleted();
        Events.raise(new FileDeletedEvent(command.userId(), file));
    }

    //todo 알집다운
    public void fileDownload(FileDownloadCommand command) {
        //todo security 적용하면 변경해야 한다
        if (!userService.isExistUser(command.userId())) throw new UserNotFoundException();
        File file = fileRepository.findById(command.fileId()).orElseThrow(FileNotFoundException::new);
        fileProcessService.downloadFile(file.getPath(), file.getName());
    }
}