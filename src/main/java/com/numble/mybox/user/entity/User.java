package com.numble.mybox.user.entity;

import com.numble.mybox.common.entity.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    Long id;
    String name;
    Integer capacity;
    Integer usedCapacity;

}
