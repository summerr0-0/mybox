package com.numble.mybox.folder.controller.request;

public record FolderCreateRequest(Long userId, String name, Long parentFolderId) {
}