package eu.haslgruebler.core.api.facade;

import java.util.Collection;

import eu.haslgruebler.core.api.Course;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public interface CourseFacade {
    /**
     * load course with the given id
     * 
     * @param id of a {@link Course}
     * @return {@link Course}
     */
    Course getCourse(Long id);

    /**
     * 
     * @return {@link Collection} of {@link Course}
     */
    Collection<Course> findAllCourses();

    /**
     * delete a course with the given id
     * 
     * @param id of a {@link Course}
     */
    void deleteCourse(Long id);

    /**
     * save a given course
     * 
     * @param course to save
     */
    void saveCourse(Course course);

}
