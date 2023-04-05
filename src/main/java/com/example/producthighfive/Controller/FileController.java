package com.example.producthighfive.Controller;

import com.example.producthighfive.Model.File;
import com.example.producthighfive.Repository.FileRepository;
import com.example.producthighfive.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    FileRepository fileRepository;
    @Autowired
    FileService fileService;

    @PostMapping("/")
    public ResponseEntity<File> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File fileEntity = fileService.uploadFile(file);
        return new ResponseEntity<>(fileEntity, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public String deleteFile( @PathVariable Long id){
        fileService.deleteById(id);
        return "Delete Successfully!!";
    }

    @GetMapping("/")
    public List<File> fetchFile(){
        return (List<File>) fileService.fetchAllFile();
    }


}
