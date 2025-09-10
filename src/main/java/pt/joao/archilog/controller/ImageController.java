package pt.joao.archilog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pt.joao.archilog.service.ImageService;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController { 

    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {

        try { 

            String imageId = imageService.uploadImage(file);
            return ResponseEntity.ok("Image uploaded successfully with ID: " + imageId); 

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Image upload failed: " + e.getMessage());
        } 

    } 

} 