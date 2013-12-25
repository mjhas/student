package eu.haslgruebler.core.data.repository;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import eu.haslgruebler.core.data.dao.StudentDAO;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
@Repository
public class StudentRepository {

    private MongoTemplate mongoTemplate;

    /**
     * 
     */
    private StudentRepository() {
        super();
    }

    /**
     * 
     * @param mongoTemplate .
     */
    public StudentRepository(MongoTemplate mongoTemplate) {
        this();
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Mongo Collection Name
     */
    public static final String COLLECTION_NAME = "Student";

    /**
     * add a student in the collection
     * 
     * @param studentDAO .
     */
    public void addStudentDAO(StudentDAO studentDAO) {
        if (!mongoTemplate.collectionExists(StudentDAO.class)) {
            mongoTemplate.createCollection(StudentDAO.class);
        }
        studentDAO.setId(System.currentTimeMillis());
        mongoTemplate.insert(studentDAO, COLLECTION_NAME);
    }

    /**
     * list all coures in the collection
     * 
     * @return {@link List} of {@link StudentDAO}
     */
    public List<StudentDAO> listStudentDAO() {
        return mongoTemplate.findAll(StudentDAO.class, COLLECTION_NAME);
    }

    /**
     * delete the given student
     * 
     * @param studentDAO to delete
     */
    public void deleteStudentDAO(StudentDAO studentDAO) {
        mongoTemplate.remove(studentDAO, COLLECTION_NAME);
    }

    /**
     * delete {@link StudentDAO} by id
     * 
     * @param id to delete
     */
    public void deleteStudentDAO(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, StudentDAO.class, COLLECTION_NAME);
    }

    /**
     * find {@link StudentDAO} with the given id
     * 
     * @param id .
     * @return {@link StudentDAO}
     */
    public StudentDAO findStudentDAO(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, StudentDAO.class, COLLECTION_NAME);
    }

    /**
     * update the given {@link StudentDAO} in the collection
     * 
     * @param couresDAO to save
     */
    public void updateStudentDAO(StudentDAO couresDAO) {
        if (!mongoTemplate.collectionExists(StudentDAO.class)) {
            mongoTemplate.createCollection(StudentDAO.class);
        }
        mongoTemplate.save(couresDAO, COLLECTION_NAME);
    }
}