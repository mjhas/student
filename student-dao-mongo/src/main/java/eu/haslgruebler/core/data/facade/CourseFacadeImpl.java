package eu.haslgruebler.core.data.facade;

import java.util.Collection;

import eu.haslgruebler.core.api.Course;
import eu.haslgruebler.core.api.facade.CourseFacade;
import eu.haslgruebler.core.data.dao.CourseDAO;
import eu.haslgruebler.core.data.mapper.CourseMapper;
import eu.haslgruebler.core.data.repository.CourseRepository;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public class CourseFacadeImpl implements CourseFacade {

    private CourseRepository courseRepository;
    private CourseMapper courseMapper;

    /**
     * 
     * @param courseRepository .
     * @param courseMapper .
     */
    public CourseFacadeImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public Course getCourse(Long id) {
        return courseMapper.map(courseRepository.findCourseDAO(id));
    }

    @Override
    public Collection<Course> findAllCourses() {
        return courseMapper.map(courseRepository.listCourseDAO());
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteCourseDAO(id);
    }

    @Override
    public void saveCourse(Course course) {
        if (course.getId() == null) {
            courseRepository.addCourseDAO(courseMapper.map(course, new CourseDAO()));
        } else {
            courseRepository.updateCourseDAO(courseMapper.map(course, courseRepository.findCourseDAO(course.getId())));
        }

    }
}
