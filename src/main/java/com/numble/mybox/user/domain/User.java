package com.numble.mybox.user.domain;

import com.numble.mybox.common.entity.BaseTimeEntity;
import com.numble.mybox.common.event.UserJoinedEvent;
import com.numble.mybox.common.value.Unit;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.numble.mybox.common.value.Unit.GB;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    Long id;

    String name;

    String userId;

    String password;
    Long capacity;
    Long usedCapacity;

    public static User of(UserJoinedEvent event) {
        return new User(
            event.getName(),
            event.getUserId(),
            event.getPassword(),
            30 * GB,
            0L);
    }

    public User(String name, String userId, String password, Long capacity, Long usedCapacity) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.capacity = capacity;
        this.usedCapacity = usedCapacity;
    }
}