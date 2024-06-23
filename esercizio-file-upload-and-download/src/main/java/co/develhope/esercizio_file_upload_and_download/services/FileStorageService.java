package co.develhope.esercizio_file_upload_and_download.services;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileStorageService {
    @Value("${fileFolder}")
    private String fileFolder;

    public String upload(MultipartFile file) throws IOException {
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = UUID.randomUUID().toString() + "." + ext;
        File finalDest = new File(fileFolder + "\\" + newFileName);
        if (finalDest.exists()) throw new IOException("Folder does not exist");
        file.transferTo(finalDest);
        return newFileName;
    }

    public byte[] download(String file) throws IOException {
        File fileFromFolder = new File(fileFolder + "\\" + file);
        if (!fileFromFolder.exists()) throw new IOException("File does not exist");
        return IOUtils.toByteArray(new FileInputStream(fileFromFolder));
    }
}
