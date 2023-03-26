package com.numble.mybox.user.domain;

import com.numble.mybox.common.entity.BaseTimeEntity;
import com.numble.mybox.user.service.command.UserCreateCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.numble.mybox.common.value.Unit.GB;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String userId;

    private String password;
    private Long capacity;
    private Long usedCapacity;

    public static User of(UserCreateCommand command) {
        return new User(
            command.name(),
            command.userId(),
            command.password(),
            30 * GB,
            0L);
    }

    private User(String name, String userId, String password, Long capacity, Long usedCapacity) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.capacity = capacity;
        this.usedCapacity = usedCapacity;
    }

    public void updateStorage(Long size) {
        this.usedCapacity += size;
    }

    public Long calculationRemainingCapacity() {
        return capacity - usedCapacity;
    }
}