package pt.joao.archilog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pt.joao.archilog.model.ImageDocument;

@Repository
public interface ImageRepository extends MongoRepository<ImageDocument, String> {

} 