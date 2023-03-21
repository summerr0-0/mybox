package com.numble.mybox.user.service;

import com.numble.mybox.common.event.Events;
import com.numble.mybox.common.event.UserJoinedEvent;
import com.numble.mybox.user.domain.User;
import com.numble.mybox.user.infra.repository.UserRepository;
import com.numble.mybox.user.service.command.UserCreateCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {
    private final UserRepository repository;

    public void join(UserCreateCommand command) {
        Events.raise(UserJoinedEvent.of(command));
    }
    public void updateStorage(Long userId, Long size) {

    }

    public boolean isFull(Long userId) {
        return false;
    }

    public boolean isExistUser(Long userId) {
        return false;
    }

    public void userCreate(UserJoinedEvent event){
        repository.save(User.of(event));
    }


}
