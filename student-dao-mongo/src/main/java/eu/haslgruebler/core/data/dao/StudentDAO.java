package eu.haslgruebler.core.data.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
@Document
public class StudentDAO {
    @Id
    private Long id;
    private String name;
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
