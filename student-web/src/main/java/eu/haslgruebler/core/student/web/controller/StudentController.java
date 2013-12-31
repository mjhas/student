package eu.haslgruebler.core.student.web.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import eu.haslgruebler.core.api.Course;
import eu.haslgruebler.core.api.Student;
import eu.haslgruebler.core.api.facade.CourseFacade;
import eu.haslgruebler.core.api.facade.StudentFacade;
import eu.haslgruebler.core.ui.api.CSSAsset;
import eu.haslgruebler.core.ui.api.CorePageController;
import eu.haslgruebler.core.ui.api.JavascriptAsset;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
@Controller
@RequestMapping("/student")
public class StudentController extends CorePageController {
    private StudentFacade studentFacade;
    private CourseFacade courseFacade;

    /**
     * 
     */
    private StudentController() {
        super("/student/student.jsp", new JavascriptAsset("student", "/student/student.js"), new CSSAsset("student", "/student/student.css"));
    }

    /**
     * 
     * @param studentFacade .
     * @param courseFacade .
     */
    public StudentController(StudentFacade studentFacade, CourseFacade courseFacade) {
        this();
        this.courseFacade = courseFacade;
        this.studentFacade = studentFacade;
    }

    /**
     * register create template page
     * 
     * @return the viewName
     */
    @RequestMapping(value = "/api/create.html", method = RequestMethod.GET)
    public String create() {
        return "student/template/create";
    }

    /**
     * register list template page
     * 
     * @return the viewName
     */
    @RequestMapping(value = "/api/list.html", method = RequestMethod.GET)
    public String list() {
        return "student/template/list";
    }

    /**
     * register dialog template page
     * 
     * @return the viewName
     */
    @RequestMapping(value = "/api/dialog.html", method = RequestMethod.GET)
    public String dialog() {
        return "student/template/dialog";
    }

    /**
     * returns all students
     * 
     * @return {@link Collection} of {@link Student}
     */
    @RequestMapping(value = "/api/", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Student> getStudents() {
        return studentFacade.findAllStudents();
    }

    /**
     * returns all courses
     * 
     * @return {@link Collection} of {@link Course}
     */
    @RequestMapping(value = "/api/courses", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Course> getCourses() {
        return courseFacade.findAllCourses();
    }

    /**
     * save a student
     * 
     * @param student to save
     * @return OK or Exception
     */
    @RequestMapping(value = "/api/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody Student student) {
        studentFacade.saveStudent(student);
        return "";
    }

    /**
     * delete a student by the given id
     * 
     * @param id of a {@link Student}
     * @return ""
     */
    @RequestMapping(value = "/api/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable Long id) {
        studentFacade.deleteStudent(id);
        return "";
    }
}
