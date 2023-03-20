package com.numble.mybox.file.infra.repository;

import com.numble.mybox.file.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
