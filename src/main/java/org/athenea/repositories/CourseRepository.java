package org.athenea.repositories;

import java.util.List;

import org.athenea.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CourseRepository extends MongoRepository<Course, String> {
    public Course findById(String id);
    public List<Course> findByNameLike(String name);
    public List<Course> findByProfesorEmail(String profesor);
    public List<Course> findByTags(String tag);
    
    


    /* TODO: 
    *   find by all
    *
    *
    *
    *
    *
    *
    *
    */

}
