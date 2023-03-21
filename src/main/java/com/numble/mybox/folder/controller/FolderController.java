package com.numble.mybox.folder.controller;

import com.numble.mybox.common.controller.response.EmptyResponse;
import com.numble.mybox.folder.controller.request.FolderCreateRequest;
import com.numble.mybox.folder.service.FolderService;
import com.numble.mybox.folder.service.command.FolderCreateCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/folder")
public class FolderController {
    private final FolderService service;

    @PostMapping
    public EmptyResponse createFolder(FolderCreateRequest request){
        log.info("createFolder :: request is {}", request.toString());
        service.createFolder(FolderCreateCommand.of(request));

        return new EmptyResponse.Ok<>();
    }

}
