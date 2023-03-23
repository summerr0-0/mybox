package com.numble.mybox.user.service;

import com.numble.mybox.common.event.Events;
import com.numble.mybox.common.event.UserJoinedEvent;
import com.numble.mybox.user.domain.User;
import com.numble.mybox.user.infra.repository.UserRepository;
import com.numble.mybox.user.service.command.UserCreateCommand;
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
        //id검사하기
        Events.raise(UserJoinedEvent.of(command));
    }
    public void updateStorage(Long userId, Long size) {

    }

    public boolean isFull(Long userId) {
        return false;
    }

    public boolean isExistUser(Long userId) {
        return true;
    }

    @Transactional
    public void userCreate(UserJoinedEvent event){
        repository.save(User.of(event));
    }


}
