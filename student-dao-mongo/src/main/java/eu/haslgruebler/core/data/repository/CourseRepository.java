package eu.haslgruebler.core.data.repository;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import eu.haslgruebler.core.data.dao.CourseDAO;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
@Repository
public class CourseRepository {

    private MongoTemplate mongoTemplate;

    /**
     * 
     */
    private CourseRepository() {
        super();
    }

    /**
     * 
     * @param mongoTemplate .
     */
    public CourseRepository(MongoTemplate mongoTemplate) {
        this();
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Mongo Collection Name
     */
    public static final String COLLECTION_NAME = "Course";

    /**
     * add a course in the collection
     * 
     * @param courseDAO .
     */
    public void addCourseDAO(CourseDAO courseDAO) {
        if (!mongoTemplate.collectionExists(CourseDAO.class)) {
            mongoTemplate.createCollection(CourseDAO.class);
        }
        courseDAO.setId(System.currentTimeMillis());
        mongoTemplate.insert(courseDAO, COLLECTION_NAME);
    }

    /**
     * list all coures in the collection
     * 
     * @return {@link List} of {@link CourseDAO}
     */
    public List<CourseDAO> listCourseDAO() {
        return mongoTemplate.findAll(CourseDAO.class, COLLECTION_NAME);
    }

    /**
     * delete the given course
     * 
     * @param courseDAO to delete
     */
    public void deleteCourseDAO(CourseDAO courseDAO) {
        mongoTemplate.remove(courseDAO, COLLECTION_NAME);
    }

    /**
     * delete {@link CourseDAO} by id
     * 
     * @param id to delete
     */
    public void deleteCourseDAO(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, CourseDAO.class, COLLECTION_NAME);
    }

    /**
     * find {@link CourseDAO} with the given id
     * 
     * @param id .
     * @return {@link CourseDAO}
     */
    public CourseDAO findCourseDAO(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, CourseDAO.class, COLLECTION_NAME);
    }

    /**
     * update the given {@link CourseDAO} in the collection
     * 
     * @param couresDAO to save
     */
    public void updateCourseDAO(CourseDAO couresDAO) {
        if (!mongoTemplate.collectionExists(CourseDAO.class)) {
            mongoTemplate.createCollection(CourseDAO.class);
        }
        mongoTemplate.save(couresDAO, COLLECTION_NAME);
    }
}