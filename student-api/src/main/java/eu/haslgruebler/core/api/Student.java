package eu.haslgruebler.core.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public class Student {
    private Long id;
    private String name;
    private Collection<Course> enrolledCourses;

    /**
     * Default Constructor
     */
    public Student() {
        super();
        enrolledCourses = new ArrayList<Course>();
    }

    /**
     * 
     * @param id .
     * @param name .
     */
    public Student(Long id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

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

    public Collection<Course> getEnrolledCourses() {
        return Collections.unmodifiableCollection(enrolledCourses);
    }

    /**
     * 
     * @param enrolledCoures .
     */
    public void setEnrolledCourses(Collection<Course> enrolledCoures) {
        this.enrolledCourses.clear();
        if (enrolledCoures != null) {
            this.enrolledCourses.addAll(enrolledCoures);
        } else {
            this.enrolledCourses.clear();
        }
    }

    /**
     * 
     * @param course .
     */
    public void addEnrolledCourses(Course course) {
        this.enrolledCourses.add(course);
    }
}
