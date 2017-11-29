package com.yevhenii.controller;

import com.yevhenii.model.ForFiles;
import com.yevhenii.service.ForFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping("/rest")
public class UploadDownloadRESTController {

    @Autowired
    ForFilesService service;
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String handleFileUpload(
            @RequestParam("file") MultipartFile file){

        if (!file.isEmpty()) {
            String name = file.getOriginalFilename();
            try {
                byte[] bytes = file.getBytes();
                ForFiles f = new ForFiles();
                f.setName(name);
                f.setData(bytes);
                service.save(f);
                return "You successfully uploaded file into " + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload file because the file input was empty.";
        }
    }

    @RequestMapping(value = "/download", produces = MediaType.ALL_VALUE)
    HttpEntity<byte[]> getFile(
            @RequestParam(value = "name") String name) throws IOException {

        byte[] file = service.getByName(name).getData();
        HttpHeaders header = new HttpHeaders();
        header.set("Content-Disposition", "attachment; filename=" + name);
        header.setContentLength(file.length);

        return new HttpEntity<>(file, header);
    }
}
