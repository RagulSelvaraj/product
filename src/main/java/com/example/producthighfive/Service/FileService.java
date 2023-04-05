package com.example.producthighfive.Service;


import com.example.producthighfive.Model.File;
import com.example.producthighfive.Repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class FileService {


    @Autowired
    FileRepository fileRepository;
    public File uploadFile(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        String fileName = file.getOriginalFilename();
        String filePath = "/home/ragu1/Documents/uploads/" + fileName;
        FileOutputStream fos = new FileOutputStream(filePath);
        fos.write(bytes);
        fos.close();
        File fileEntity = new File();
        fileEntity.setName(fileName);
        fileEntity.setPath(filePath);
        return fileRepository.save(fileEntity);
    }


    public void deleteById(Long id) {
        fileRepository.deleteById(id);
    }

    public List<File> fetchAllFile() {
        return fileRepository.findAll();
    }
}
