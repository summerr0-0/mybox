package com.numble.mybox.user.service;

import com.numble.mybox.common.event.Events;
import com.numble.mybox.common.event.UserJoinedEvent;
import com.numble.mybox.user.controller.response.UserSearchResponse;
import com.numble.mybox.user.domain.User;
import com.numble.mybox.user.infra.repository.UserRepository;
import com.numble.mybox.user.service.command.UserCreateCommand;
import com.numble.mybox.user.service.exception.UserAlreadyExistException;
import com.numble.mybox.user.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository repository;

    @Transactional
    public void join(UserCreateCommand command) {
        repository.findByUserId(command.userId())
            .ifPresent(a -> {
                throw new UserAlreadyExistException();
            });
        User createUser = repository.save(User.of(command));
        Events.raise(UserJoinedEvent.of(createUser.getId(), command));
    }

    public void updateStorage(Long id, Long size) {
        User user = repository.findById(id)
            .orElseThrow(UserNotFoundException::new);
        user.updateStorage(size);
    }

    public boolean isFull(Long userId) {
        return false;
    }

    public boolean isExistUser(Long userId) {
        return repository.existsById(userId);
    }

    public UserSearchResponse findUser(Long id) {
        User user = repository.findById(id)
            .orElseThrow(UserNotFoundException::new);
        return UserSearchResponse.of(user);
    }

}