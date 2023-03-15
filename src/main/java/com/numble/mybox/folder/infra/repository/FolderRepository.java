package com.numble.mybox.folder.infra.repository;

import com.numble.mybox.folder.entity.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder,Long> {
}
