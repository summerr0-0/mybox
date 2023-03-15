package com.numble.mybox.file.controller;

import com.numble.mybox.common.controller.response.EmptyResponse;
import com.numble.mybox.file.controller.request.FileUploadRequest;
import com.numble.mybox.file.service.FileService;
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
    public EmptyResponse fileUpload(@RequestBody @Valid FileUploadRequest request) {
        service.fileUpload(FileUploadCommand.of(request));
        return new EmptyResponse.Ok<>();
    }
}
