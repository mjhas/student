package eu.haslgruebler.core.data.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import eu.haslgruebler.core.data.repository.CourseRepository;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
@Document(collection = CourseRepository.COLLECTION_NAME)
public class CourseDAO {
    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
