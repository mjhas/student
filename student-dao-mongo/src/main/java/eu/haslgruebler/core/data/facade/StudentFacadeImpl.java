package eu.haslgruebler.core.data.facade;

import java.util.Collection;

import eu.haslgruebler.core.api.Student;
import eu.haslgruebler.core.api.facade.StudentFacade;
import eu.haslgruebler.core.data.dao.StudentDAO;
import eu.haslgruebler.core.data.mapper.StudentMapper;
import eu.haslgruebler.core.data.repository.StudentRepository;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public class StudentFacadeImpl implements StudentFacade {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    /**
     * 
     * @param studentRepository .
     * @param studentMapper .
     */
    public StudentFacadeImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        super();
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public Student getStudent(Long id) {
        return studentMapper.map(studentRepository.findStudentDAO(id));
    }

    @Override
    public Collection<Student> findAllStudents() {
        return studentMapper.map(studentRepository.listStudentDAO());
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteStudentDAO(id);
    }

    @Override
    public void saveStudent(Student student) {
        if (student.getId() == null) {
            studentRepository.addStudentDAO(studentMapper.map(student, new StudentDAO()));
        } else {
            studentRepository.updateStudentDAO(studentMapper.map(student, studentRepository.findStudentDAO(student.getId())));
        }

    }

}
