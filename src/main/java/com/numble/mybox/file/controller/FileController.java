package com.numble.mybox.file.controller;

import com.numble.mybox.common.controller.response.EmptyResponse;
import com.numble.mybox.file.controller.request.FileDeleteRequest;
import com.numble.mybox.file.controller.request.FileGetRequest;
import com.numble.mybox.file.controller.request.FileListGetRequest;
import com.numble.mybox.file.controller.request.FileUploadRequest;
import com.numble.mybox.file.service.FileService;
import com.numble.mybox.file.service.command.FileDeleteCommand;
import com.numble.mybox.file.service.command.FileDownloadCommand;
import com.numble.mybox.file.service.command.FileUploadCommand;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/file")
public class FileController {
    private final FileService service;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public EmptyResponse fileUpload(@Valid FileUploadRequest request) {
        service.fileUpload(FileUploadCommand.of(request));
        return new EmptyResponse.Ok<>();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public EmptyResponse fileDelete(@RequestBody @Valid FileDeleteRequest request) {
        service.fileDelete(FileDeleteCommand.of(request));
        return new EmptyResponse.Ok<>();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public EmptyResponse getFile(@RequestBody @Valid FileGetRequest request) {
        service.fileDownload(FileDownloadCommand.of(request));
        return new EmptyResponse.Ok<>();
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public EmptyResponse getFileList(@RequestBody @Valid FileListGetRequest request) {
        return new EmptyResponse.Ok<>();
    }
}