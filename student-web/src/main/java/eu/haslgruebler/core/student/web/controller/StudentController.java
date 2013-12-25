package eu.haslgruebler.core.student.web.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import eu.haslgruebler.core.api.Student;
import eu.haslgruebler.core.api.facade.StudentFacade;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentFacade studentFacade;

    /**
     * 
     */
    private StudentController() {
        super();
    }

    /**
     * 
     * @param studentFacade .
     */
    public StudentController(StudentFacade studentFacade) {
        this();
        this.studentFacade = studentFacade;
    }

    /**
     * register the student root page
     * 
     * @return {@link ModelAndView}
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView get() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("forward:/");
        mav.addObject("page", "/student/student.jsp");
        return mav;
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
