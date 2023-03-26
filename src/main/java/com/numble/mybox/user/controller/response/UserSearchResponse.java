package com.numble.mybox.user.controller.response;

import com.numble.mybox.user.domain.User;

public record UserSearchResponse(Long id, Long remainingCapacity) {
    public static UserSearchResponse of(User user) {
        Long capacity = user.calculationRemainingCapacity();
        return new UserSearchResponse(user.getId(), capacity);
    }
}
