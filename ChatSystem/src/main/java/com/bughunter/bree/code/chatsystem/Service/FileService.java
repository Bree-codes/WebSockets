package com.bughunter.bree.code.chatsystem.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

        public String uploadFile(MultipartFile file) {
            // Logic to save the file to a directory or cloud storage (e.g., AWS S3, Google Cloud)
            // Return the URL of the uploaded file
            String fileUrl = "https://example.com/files/" + file.getOriginalFilename();
            // Actual upload logic omitted
            return fileUrl;
        }
}