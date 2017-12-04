package com.example.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

@RestController
@RequestMapping(value = "/api/upload")
@MultipartConfig(fileSizeThreshold = 20971520)
@CrossOrigin(origins = "*")
public class FileUploadController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile uploadedFileRef) {
        String fileName = uploadedFileRef.getOriginalFilename();

        Random random = new Random();

        String myFileName = random.nextInt(100000) + fileName;

//        String path = "/Users/tushighen/AngularProjects/poll/src/assets/image/" + myFileName;
        String path = "/Users/tushighen/IdeaProjects/projectIs/src/main/webapp/images/" + myFileName;

        byte[] buffer = new byte[1000];

        File outputFile = new File(path);

        FileInputStream reader = null;
        FileOutputStream writer = null;
        int totalBytes = 0;

        try {
            outputFile.createNewFile();

            reader = (FileInputStream) uploadedFileRef.getInputStream();

            writer = new FileOutputStream(outputFile);

            int bytesRead = 0;
            while ((bytesRead = reader.read(buffer)) != -1) {
                writer.write(buffer);
                totalBytes += bytesRead;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return myFileName;
    }
}