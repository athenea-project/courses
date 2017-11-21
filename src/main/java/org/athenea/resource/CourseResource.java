package org.athenea.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.athenea.model.Course;
import org.athenea.repositories.CourseRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class to obtain Course objects.
 */
@Path("/course")
@Api(value = "course", description = "Retrieve courses.")
public class CourseResource {

  private static final ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");   // Application context to load Spring

  private static final CourseRepository courseRepo = (CourseRepository) context.getBean("courseRepository");    // User bean to work with

  /**
   * Get all courses from DB.
   *
   * @return a List containing all courses.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/all")
  @ApiResponses(value = {@ApiResponse(code = 500, message = "Error when connecting to server."),
      @ApiResponse(code = 404, message = "No coursefound")})
  @ApiOperation(value = "Returns all courses.",
      response = Course.class)
  public List<Course> getAll() {

    return courseRepo.findAll();
  }

  /**
   * Get all courses for a tag
   *
   * @param email primary key in DB
   * @return a User object
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/tag")
  @ApiResponses(value = {@ApiResponse(code = 500, message = "Error when connecting to server."),
      @ApiResponse(code = 404, message = "No courses found")})
  @ApiOperation(value = "Returns all courses for a tag.",
      response = Course.class)
  public List<Course> getCourseByTag(@HeaderParam("tag") String tag) {

    return courseRepo.findByTags(tag);
  }


}
