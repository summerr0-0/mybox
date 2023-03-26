package com.numble.mybox.file.infra.objectstorage;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.numble.mybox.file.infra.FileProcessService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Component
public class ObjectStorageService implements FileProcessService {
    @Value("${objects-storage.endPoint}")
    private String endPoint;
    @Value("${objects-storage.regionName}")
    private String regionName;
    @Value("${objects-storage.accessKey}")
    private String accessKey;
    @Value("${objects-storage.secretKey}")
    private String secretKey;
    @Value("${objects-storage.bucketName}")
    private String bucketName;
    private AmazonS3 s3;

    @PostConstruct
    private void init() {
        s3 = AmazonS3ClientBuilder.standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, regionName))
            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
            .build();
    }

    public String uploadFile(MultipartFile file, Long userId) {
        // create folder
        String folderName = userId + "/";
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(0L);
        objectMetadata.setContentType("application/x-directory");
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, folderName, new ByteArrayInputStream(new byte[0]), objectMetadata);
        try {
            s3.putObject(putObjectRequest);
            log.info("Folder {} has been created.", folderName);
        } catch (SdkClientException e) {
            throw new SdkClientException(e.getMessage());
        }
        //create file
        String fileName = folderName + UUID.randomUUID();
        File convertFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if (convertFile.createNewFile()) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(convertFile)) {
                    fileOutputStream.write(file.getBytes());
                }
            }
            s3.putObject(bucketName, fileName, convertFile);
            System.out.format("file %s has been created.\n", fileName);
        } catch (IOException | SdkClientException e) {
            throw new SdkClientException(e.getMessage());
        }
        return s3.getUrl(bucketName, fileName).toString();
    }

    public void deleteFile(String fileName) {
        // delete object
        try {
            s3.deleteObject(bucketName, fileName);
            log.info("file {} has been deleted", fileName);
        } catch (SdkClientException e) {
            throw new SdkClientException(e.getMessage());
        }
    }

    public void downloadFile(String filePath, String fileName) {
        String objectName = fileName;
        String downloadFilePath = filePath + "/" + fileName;
        // download object
        try {
            S3Object s3Object = s3.getObject(bucketName, objectName);
            S3ObjectInputStream s3ObjectInputStream = s3Object.getObjectContent();
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(downloadFilePath));
            byte[] bytesArray = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = s3ObjectInputStream.read(bytesArray)) != -1) {
                outputStream.write(bytesArray, 0, bytesRead);
            }
            outputStream.close();
            s3ObjectInputStream.close();
            System.out.format("Object %s has been downloaded.\n", objectName);
        } catch (SdkClientException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}