package com.teratech.isis.services;

import com.teratech.exceptions.ApplicationException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public interface FileService {
    String DATA_REPO = "data";
    public final Path storagePath = Paths.get(DATA_REPO);

    /**
     *
     * @param storeName
     * @param file
     * @return
     * @throws ApplicationException
     */
     default String storeFile (String storeName, MultipartFile file) throws ApplicationException {
         try {
             if (file.isEmpty()) {
                 throw new IllegalArgumentException("Impossible de stocker un fichier vide");
             }
             if (!Files.exists(storagePath)) {
                 Files.createDirectories(storagePath);
             }
             Path destinationFile = storagePath.resolve(Paths.get(storeName))
                     .normalize().toAbsolutePath();
             Files.copy(file.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);
             return storeName;
         } catch (Exception e) {
             e.printStackTrace();
             throw new ApplicationException("500", e.getMessage(), e);
         }
    }

    default Resource dowloadFile (String storeName) throws ApplicationException {
         try {
             Path file = storagePath.resolve(storeName).normalize();
             System.out.println("-------------------Storage File  :  "+file);
             Resource resource = new UrlResource(file.toUri());
             if (resource.exists() || resource.isReadable()) {
                 return resource;
             } else {
                 return null;
             }

         } catch (Exception e) {
             e.printStackTrace();
             throw new ApplicationException("500", e.getMessage(),e);
         }

    }

    default void deleteFile (String storeName) throws ApplicationException {
        Path file = storagePath.resolve(storeName).normalize();
        try {
            Files.deleteIfExists(file);
        } catch (Exception e) {
            throw new ApplicationException("500", e.getMessage(),e);
        }
    }
}
