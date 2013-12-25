package eu.haslgruebler.core.api.facade;

import java.util.Collection;

import eu.haslgruebler.core.api.Student;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public interface StudentFacade {
    /**
     * load student with the given id
     * 
     * @param id of a {@link Student}
     * @return {@link Student}
     */
    Student getStudent(Long id);

    /**
     * 
     * @return {@link Collection} of {@link Student}
     */
    Collection<Student> findAllStudents();

    /**
     * delete a student with the given id
     * 
     * @param id of a {@link Student}
     */
    void deleteStudent(Long id);

    /**
     * save a given student
     * 
     * @param student to save
     */
    void saveStudent(Student student);

}
