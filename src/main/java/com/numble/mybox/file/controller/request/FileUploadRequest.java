package com.numble.mybox.file.controller.request;

import org.springframework.web.multipart.MultipartFile;

public record FileUploadRequest( Long userId, Long folderId, MultipartFile file) {

}
