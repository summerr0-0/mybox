package com.numble.mybox.file.infra;

import org.springframework.web.multipart.MultipartFile;

public interface FileProcessService {

    String uploadFile(MultipartFile file, Long userId);

    void deleteFile(String fileName);

    void downloadFile(String filePath, String fileName);
}
