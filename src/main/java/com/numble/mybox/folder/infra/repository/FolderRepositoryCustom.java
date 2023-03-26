package com.numble.mybox.folder.infra.repository;

public interface FolderRepositoryCustom {
    boolean existsByIdAndName(Long userId, String name, Long parentId);
}