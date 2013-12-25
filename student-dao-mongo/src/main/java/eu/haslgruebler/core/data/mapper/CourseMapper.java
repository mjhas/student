package eu.haslgruebler.core.data.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import eu.haslgruebler.core.api.Course;
import eu.haslgruebler.core.data.dao.CourseDAO;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public class CourseMapper {
    /**
     * map from source to target
     * 
     * @param source for mapping
     * @param target for mapping
     * @return mapped target
     */
    public CourseDAO map(Course source, CourseDAO target) {
        target.setName(source.getName());
        target.setId(source.getId());
        return target;
    }

    /**
     * map DAO to API Object
     * 
     * @param source .
     * @return {@link Course}
     */
    public Course map(CourseDAO source) {
        return new Course(source.getId(), source.getName());
    }

    /**
     * map DAO to API Object
     * 
     * @param sourceList .
     * @return {@link Collection} of {@link Course}
     */
    public Collection<Course> map(Collection<CourseDAO> sourceList) {
        List<Course> targetList = new ArrayList<Course>(sourceList.size());
        for (CourseDAO source : sourceList) {
            targetList.add(map(source));
        }
        return targetList;
    }

    /**
     * map from sourceList to targetList
     * 
     * @param sourceList .
     * @param targetList .
     * @return {@link Collection} of {@link CourseDAO}
     */
    public Collection<CourseDAO> map(Collection<Course> sourceList, Collection<CourseDAO> targetList) {
        for (Course source : sourceList) {
            targetList.add(map(source, new CourseDAO()));
        }
        return targetList;
    }
}
