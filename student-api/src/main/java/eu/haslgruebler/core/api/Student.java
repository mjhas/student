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
    private Collection<Course> enrolledCoures;

    /**
     * Default Constructor
     */
    public Student() {
        super();
        enrolledCoures = new ArrayList<Course>();
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

    public Collection<Course> getEnrolledCoures() {
        return Collections.unmodifiableCollection(enrolledCoures);
    }

    /**
     * 
     * @param enrolledCoures .
     */
    public void setEnrolledCoures(Collection<Course> enrolledCoures) {
        this.enrolledCoures.clear();
        if (enrolledCoures != null) {
            this.enrolledCoures.addAll(enrolledCoures);
        } else {
            this.enrolledCoures.clear();
        }
    }

    /**
     * 
     * @param course .
     */
    public void addEnrolledCourses(Course course) {
        this.enrolledCoures.add(course);
    }
}
