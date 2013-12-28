package eu.haslgruebler.core.student.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import eu.haslgruebler.core.api.facade.CourseFacade;
import eu.haslgruebler.core.api.facade.StudentFacade;
import eu.haslgruebler.core.student.web.controller.CourseController;
import eu.haslgruebler.core.student.web.controller.StudentController;
import eu.haslgruebler.core.ui.api.MenuItem;

/**
 * Spring Configuration for Web Module
 * 
 * @author Michael Haslgrübler
 * 
 */
@EnableWebMvc
@Configuration
public class StudentWebConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private StudentFacade studentFacade;

    @Autowired
    private CourseFacade courseFacade;

    /**
     * @return {@link StudentController}
     */
    @Bean
    public StudentController studentController() {
        return new StudentController(studentFacade);
    }

    /**
     * @return {@link CourseController}
     */
    @Bean
    public CourseController courseController() {
        return new CourseController(courseFacade);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/student/**").addResourceLocations("classpath:/student/");
    }

    /**
     * 
     * @return {@link MenuItem} for students
     */
    @Bean
    MenuItem studentMenu() {
        MenuItem student = new MenuItem("menu.student", "student/");
        student.addSubMenuItem(new MenuItem("menu.student", "student/#"));
        return student;
    }

    /**
     * 
     * @return {@link MenuItem} for coures
     */
    @Bean
    MenuItem courseMenu() {
        MenuItem course = new MenuItem("menu.course", "course/");
        return course;
    }

    /**
     * register a MessageSource for internationalisation 
     * 
     * @return {@link MessageSource} for i18n
     */
    @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource ret = new ReloadableResourceBundleMessageSource();
        ret.setBasename("classpath:message");
        ret.setDefaultEncoding("UTF-8");
        return ret;
    }

}
