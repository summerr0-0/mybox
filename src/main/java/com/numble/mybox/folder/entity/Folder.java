package com.numble.mybox.folder.entity;

import com.numble.mybox.common.entity.BaseTimeEntity;
import com.numble.mybox.common.event.UserJoinedEvent;
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


    public static Folder createRoot(Long userId) {
        return new Folder(userId, "root", null);
    }

    public Folder(Long userId, String name, Long parentId) {
        this.userId = userId;
        this.name = name;
        this.parentId = parentId;
    }
}
