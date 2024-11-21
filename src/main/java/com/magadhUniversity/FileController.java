package com.magadhUniversity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/files")
public class FileController {

    private final String uploadDir;
    private final String pdfDir;
    private final String photoDir;

    @Autowired
    public FileController(@Value("${file.upload-dir}") String uploadDir,
                          @Value("${file.pdf-dir}") String pdfDir,
                          @Value("${file.photo-dir}") String photoDir) {
        this.uploadDir = uploadDir;
        this.pdfDir = pdfDir;
        this.photoDir = photoDir;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String originalFileName = file.getOriginalFilename();
            String newFileName = UUID.randomUUID().toString() + "_" + originalFileName;
            Path targetLocation = null;

            if (originalFileName.endsWith(".pdf")) {
                targetLocation = Paths.get(pdfDir).resolve(newFileName);
            } else if (originalFileName.endsWith(".jpg") || originalFileName.endsWith(".jpeg") || originalFileName.endsWith(".png")) {
                targetLocation = Paths.get(photoDir).resolve(newFileName);
            } else {
                targetLocation = Paths.get(uploadDir).resolve(newFileName);
            }

            Files.copy(file.getInputStream(), targetLocation);
            return ResponseEntity.ok("File uploaded successfully: " + newFileName);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Could not upload the file: " + e.getMessage());
        }
    }

    @GetMapping("/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        try {
            Resource file = findFile(filename);

            if (file != null && file.exists() && file.isReadable()) {
                MediaType mediaType = getMediaType(file.getFile().toPath());
                return ResponseEntity.ok()
                        .contentType(mediaType)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + filename + "\"")
                        .body(file);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    private Resource findFile(String filename) throws IOException {
        Path[] paths = {
                Paths.get(uploadDir).resolve(filename),
                Paths.get(pdfDir).resolve(filename),
                Paths.get(photoDir).resolve(filename),
        };

        for (Path path : paths) {
            Resource file = new UrlResource(path.toUri());
            if (file.exists() && file.isReadable()) {
                return file;
            }
        }
        return null;
    }

    private MediaType getMediaType(Path filePath) {
        String fileName = filePath.getFileName().toString().toLowerCase();
        if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
            return MediaType.IMAGE_JPEG;
        } else if (fileName.endsWith(".png")) {
            return MediaType.IMAGE_PNG;
        } else {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }
}
