package eu.haslgruebler.core.api;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public class Course {
    private Long id;
    private String name;

    /**
     * Default Constructor
     */
    public Course() {
        super();
    }

    /**
     * 
     * @param id .
     * @param name .
     */
    public Course(Long id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
