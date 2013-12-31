package eu.haslgruebler.core.data.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import eu.haslgruebler.core.data.repository.StudentRepository;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
@Document(collection = StudentRepository.COLLECTION_NAME)
public class StudentDAO {
    @Id
    private Long id;
    private String name;
    @DBRef()
    private Collection<CourseDAO> enrolledCourses = new ArrayList<CourseDAO>();

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

    public Collection<CourseDAO> getEnrolledCoures() {
        return Collections.unmodifiableCollection(enrolledCourses);
    }

    /**
     * @param enrolledCourses .
     */
    public void setEnrolledCourses(Collection<CourseDAO> enrolledCourses) {
        if (enrolledCourses != null) {
            this.enrolledCourses.clear();
            this.enrolledCourses.addAll(enrolledCourses);
        } else {
            this.enrolledCourses.clear();
        }
    }
}
