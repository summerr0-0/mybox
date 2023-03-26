package com.numble.mybox.folder.service;

import com.numble.mybox.common.event.UserJoinedEvent;
import com.numble.mybox.folder.entity.Folder;
import com.numble.mybox.folder.infra.repository.FolderRepository;
import com.numble.mybox.folder.service.command.FolderCreateCommand;
import com.numble.mybox.user.domain.User;
import com.numble.mybox.user.infra.repository.UserRepository;
import com.numble.mybox.user.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class FolderService {
    private final FolderRepository fileRepository;
    private final UserRepository userRepository;

    public void rootCreate(UserJoinedEvent event) {
        User user = userRepository.findById(event.getId()).orElseThrow(UserNotFoundException::new);
        fileRepository.save(Folder.createRoot(user.getId()));
    }

    @Transactional
    public void createFolder(FolderCreateCommand command) {
        userRepository.findById(command.userId())
            .orElseThrow(UserNotFoundException::new);
        boolean existsFolder = fileRepository.existsByIdAndName(
            command.userId(),
            command.name(),
            command.parentFolderId());
        if (existsFolder) {
            throw new IllegalArgumentException("폴더가 이미 존재합니다.");
        }
        fileRepository.save(Folder.of(command));
    }
}