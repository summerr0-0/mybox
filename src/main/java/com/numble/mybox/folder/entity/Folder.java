package com.numble.mybox.folder.entity;

import com.numble.mybox.common.entity.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Folder extends BaseTimeEntity {
    @Id
    Long id;
    Long userId;
    String name;
    Long parentId;
}
