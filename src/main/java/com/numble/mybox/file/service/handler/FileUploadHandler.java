package com.numble.mybox.file.service.handler;

import com.numble.mybox.common.event.FileUploadedEvent;
import com.numble.mybox.file.domain.File;
import com.numble.mybox.file.infra.objectstorage.ObjectStorageService;
import com.numble.mybox.file.infra.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class FileUploadHandler {
    private final ObjectStorageService objectStorageService;
    private final FileRepository fileRepository;

    @EventListener(FileUploadedEvent.class)
    public void handle(FileUploadedEvent event) {
        log.info("FileUploadedEvent :: FileUploadHandler start");

        String result = objectStorageService.uploadFile(event.getFile(), event.getUserId());

        fileRepository.save(File.of(
            event.getUserId(),
            event.getFile().getName(),
            result,
            event.getFolderId(),
            event.getFile().getSize()
        ));

    }

}
