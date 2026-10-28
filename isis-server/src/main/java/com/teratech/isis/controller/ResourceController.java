package com.teratech.isis.controller;

import com.teratech.exceptions.ApplicationException;
import com.teratech.isis.services.FileService;
import com.teratech.utils.ApplicationConstans.API;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
@RequestMapping(API.API_PREFIX+"/file")
public class ResourceController {

    private final FileService fileService;

    public ResourceController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, value = "/upload")
    public ResponseEntity<?> upload(@RequestParam("name") String name
            , @RequestParam(value = "file") MultipartFile file) throws ApplicationException {

            return ResponseEntity.ok(fileService.storeFile(name, file));

    }

    /**
     *
     * @param file
     * @return
     * @throws ApplicationException
     */
    @GetMapping("/download/{file:.+}")
    public ResponseEntity<Resource> storeFile(@PathVariable(name = "file") String  file) throws ApplicationException {

            Resource resource = fileService.dowloadFile(file);

            if (Objects.nonNull(resource)) {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            }
          throw new ApplicationException("404", "Resource not found");
    }

    /**
     *
     * @param file
     * @return
     * @throws ApplicationException
     */
    @DeleteMapping("/delete/{file:.+}")
    public ResponseEntity<?> deleteFile(@PathVariable(name = "file") String  file) throws ApplicationException {
             fileService.deleteFile(file);
             return ResponseEntity.ok().build();
    }
}
