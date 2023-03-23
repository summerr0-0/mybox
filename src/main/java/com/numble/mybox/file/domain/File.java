package com.numble.mybox.file.domain;

import com.numble.mybox.common.entity.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class File extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private String name;
    private String path;
    private Long folderId;
    private Long size;
//    String fimeNameExtemtion;


    public static File of(Long userId, String name, String path, Long folderId, Long size) {
        return new File(userId, name, path, folderId, size);
    }

    private File(Long userId, String name, String path, Long folderId, Long size) {
        this.userId = userId;
        this.name = name;
        this.path = path;
        this.folderId = folderId;
        this.size = size;
    }

}
