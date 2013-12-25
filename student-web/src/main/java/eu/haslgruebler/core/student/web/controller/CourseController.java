package eu.haslgruebler.core.student.web.controller;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import eu.haslgruebler.core.api.Course;
import eu.haslgruebler.core.api.facade.CourseFacade;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    private CourseFacade courseFacade;

    /**
     * 
     */
    private CourseController() {
        super();
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
     * register the course root page
     * 
     * @return {@link ModelAndView}
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView get() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("forward:/");
        mav.addObject("page", "/course/course.jsp");
        return mav;
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
