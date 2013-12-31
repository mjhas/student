package eu.haslgruebler.core.student.web.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import eu.haslgruebler.core.api.Course;
import eu.haslgruebler.core.api.facade.CourseFacade;
import eu.haslgruebler.core.ui.api.CSSAsset;
import eu.haslgruebler.core.ui.api.CorePageController;
import eu.haslgruebler.core.ui.api.JavascriptAsset;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
@Controller
@RequestMapping("/course")
public class CourseController extends CorePageController {
    private CourseFacade courseFacade;

    /**
     * 
     */
    private CourseController() {
        super("/course/course.jsp", new JavascriptAsset("course", "/student/course.js"), new CSSAsset("student", "/student/course.css"));
    }

    /**
     * 
     * @param courseFacade .
     */
    public CourseController(CourseFacade courseFacade) {
        this();
        this.courseFacade = courseFacade;
    }

    /**
     * register create template page
     * 
     * @return the viewName
     */
    @RequestMapping(value = "/api/create.html", method = RequestMethod.GET)
    public String create() {
        return "course/template/create";
    }
    
    /**
     * register dialog template page
     * 
     * @return the viewName
     */
    @RequestMapping(value = "/api/dialog.html", method = RequestMethod.GET)
    public String dialog() {
        return "course/template/dialog";
    }
    
    /**
     * register list template page
     * 
     * @return the viewName
     */
    @RequestMapping(value = "/api/list.html", method = RequestMethod.GET)
    public String list() {
        return "course/template/list";
    }

    /**
     * returns all courses
     * 
     * @return {@link Collection} of {@link Course}
     */
    @RequestMapping(value = "/api/", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Course> getCourses() {
        return courseFacade.findAllCourses();
    }

    /**
     * save a course
     * 
     * @param course to save
     * @return OK or Exception
     */
    @RequestMapping(value = "/api/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody Course course) {
        courseFacade.saveCourse(course);
        return "";
    }

    /**
     * delete a course by the given id
     * 
     * @param id of a {@link Course}
     * @return ""
     */
    @RequestMapping(value = "/api/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable Long id) {
        courseFacade.deleteCourse(id);
        return "";
    }
}
