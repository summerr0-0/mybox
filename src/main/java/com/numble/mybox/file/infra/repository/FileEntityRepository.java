package com.numble.mybox.file.infra.repository;

import com.numble.mybox.file.domain.File;
import com.numble.mybox.file.domain.FileRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileEntityRepository extends JpaRepository<File, Long>, FileRepository {
}
