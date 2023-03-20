package com.numble.mybox.folder.service;

import com.numble.mybox.common.event.UserJoinedEvent;
import com.numble.mybox.folder.entity.Folder;
import com.numble.mybox.folder.infra.repository.FolderRepository;
import com.numble.mybox.user.domain.User;
import com.numble.mybox.user.infra.repository.UserRepository;
import com.numble.mybox.user.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class FolderService {
    private final FolderRepository fileRepository;
    private final UserRepository userRepository;

    public void rootCreate(UserJoinedEvent event) {
        User user = userRepository.findByUserId(event.getUserId()).orElseThrow(UserNotFoundException::new);
        fileRepository.save(Folder.createRoot(user.getId()));
    }
}
