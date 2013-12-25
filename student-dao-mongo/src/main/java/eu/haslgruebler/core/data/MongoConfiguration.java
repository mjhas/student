package eu.haslgruebler.core.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

import eu.haslgruebler.core.api.facade.CourseFacade;
import eu.haslgruebler.core.api.facade.StudentFacade;
import eu.haslgruebler.core.data.facade.CourseFacadeImpl;
import eu.haslgruebler.core.data.facade.StudentFacadeImpl;
import eu.haslgruebler.core.data.mapper.CourseMapper;
import eu.haslgruebler.core.data.mapper.StudentMapper;
import eu.haslgruebler.core.data.repository.CourseRepository;
import eu.haslgruebler.core.data.repository.StudentRepository;

/**
 * Spring Configuration for MongoDB Backend
 * 
 * @author Michael Haslgrübler
 * 
 */
@Configuration
@EnableMongoRepositories
@ComponentScan(basePackageClasses = { MongoConfiguration.class })
@PropertySource("classpath:META-INF/mongo.properties")
public class MongoConfiguration extends AbstractMongoConfiguration {

    private StudentMapper studentMapper;
    private CourseMapper courseMapper;

    /**
     * 
     * @return {@link CourseFacade}
     * @throws Exception .
     */
    @Bean
    public StudentFacade studentFacade() throws Exception {
        return new StudentFacadeImpl(studentRepository(), studentMapper());
    }

    /**
     * 
     * @return {@link CourseFacade}
     * @throws Exception .
     */
    @Bean
    public CourseFacade courseFacade() throws Exception {
        return new CourseFacadeImpl(courseRepository(), courseMapper());
    }

    /**
     * 
     * @return {@link StudentRepository}
     * @throws Exception .
     */
    private StudentRepository studentRepository() throws Exception {
        return new StudentRepository(mongoTemplate());
    }

    /**
     * 
     * @return {@link StudentMapper}
     */
    private StudentMapper studentMapper() {
        if (studentMapper == null) {
            studentMapper = new StudentMapper(courseMapper());
        }
        return studentMapper;
    }

    /**
     * 
     * @return {@link CourseMapper}
     */
    private CourseMapper courseMapper() {
        if (courseMapper == null) {
            courseMapper = new CourseMapper();
        }
        return courseMapper;
    }

    /**
     * 
     * @return {@link CourseRepository}
     * @throws Exception .
     */
    private CourseRepository courseRepository() throws Exception {
        return new CourseRepository(mongoTemplate());
    }

    @Override
    protected String getDatabaseName() {
        return "demo";
    }

    @Override
    protected UserCredentials getUserCredentials() {
        return new UserCredentials("test", "test");
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Mongo();
    }

    @Override
    protected String getMappingBasePackage() {
        return "eu.haslgruebler.core.data";
    }

}