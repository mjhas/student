package eu.haslgruebler.core.data.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import eu.haslgruebler.core.api.Student;
import eu.haslgruebler.core.data.dao.StudentDAO;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public class StudentMapper {

    private CourseMapper courseMapper;

    /**
     * @param courseMapper .
     */
    public StudentMapper(CourseMapper courseMapper) {
        super();
        this.courseMapper = courseMapper;
    }

    /**
     * map from source to target
     * 
     * @param source .
     * @param target .
     * @return the mapped target
     */
    public StudentDAO map(Student source, StudentDAO target) {
        target.setName(source.getName());
        target.setId(source.getId());
        target.setEnrolledCourses(courseMapper.map(source.getEnrolledCoures(), target.getEnrolledCoures()));
        return target;
    }

    /**
     * map DAO to API Object
     * 
     * @param source .
     * @return {@link Student}
     */
    public Student map(StudentDAO source) {
        return new Student(source.getId(), source.getName());
    }

    /**
     * map DAO to API Object
     * 
     * @param sourceList .
     * @return {@link Collection} of {@link Student}
     */
    public Collection<Student> map(Collection<StudentDAO> sourceList) {
        List<Student> targetList = new ArrayList<Student>(sourceList.size());
        for (StudentDAO source : sourceList) {
            targetList.add(map(source));
        }
        return targetList;
    }

}
