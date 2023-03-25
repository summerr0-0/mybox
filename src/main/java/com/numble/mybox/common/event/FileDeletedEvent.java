package com.numble.mybox.common.event;

import com.numble.mybox.file.domain.File;
import lombok.Getter;

@Getter
public class FileDeletedEvent {

    private final Long userId;
    private final File file;

    public FileDeletedEvent(Long userId, File file) {
        this.userId = userId;
        this.file = file;
    }
}
