package pt.joao.archilog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pt.joao.archilog.model.ImageDocument;
import pt.joao.archilog.repository.ImageRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService { 

    private final ImageRepository imageRepository;

    public String uploadImage(MultipartFile file) throws IOException {

        ImageDocument image = new ImageDocument();
        image.setName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setImageData(file.getBytes()); 

        image = imageRepository.save(image); 

        return image.getId(); 

    } 

} 

 