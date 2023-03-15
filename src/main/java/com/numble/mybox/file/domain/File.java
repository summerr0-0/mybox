package com.numble.mybox.file.domain;

import com.numble.mybox.common.entity.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class File extends BaseTimeEntity {
    @Id
    Long id;
    Long userId;
    String name;
    String folder;

}
