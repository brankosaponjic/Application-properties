package brankosaponjic.course.controller;

import brankosaponjic.course.configuration.CourseConfiguration;
import brankosaponjic.course.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class RestEndpoints {

    @Value("${default.course.name}")
    private String courseName;

    @Value("${default.course.chapterCount}")
    private int courseChapterCounter;

    @Autowired
    private CourseConfiguration configuration;

    @RequestMapping("/defaultCourse")
    public Course getDefaultCourse(
            @RequestParam(value = "name", defaultValue = "Spring Boot", required = false) String name,
            @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount) {
        return new Course(courseName, courseChapterCounter);
    }

    @RequestMapping("/getHierarchical")
    public HashMap<String, Object> getConfigAnnotateProperties() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", configuration.getName());
        map.put("characterCount", configuration.getChapterCount());
        map.put("rating", configuration.getRating());
        map.put("author", configuration.getAuthor());

        return map;
    }

    @RequestMapping("/course")
    public Course getEndpoint(
            @RequestParam(value = "name", defaultValue = "Spring Boot", required = false) String name,
            @RequestParam(value = "chapterCount", defaultValue = "2", required = false) int chapterCount) {
         return new Course(name, chapterCount);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register/course")
    public String saveCourse(@RequestBody Course course) {
        return "Your course named: " + course.getName() + ", with " + course.getChapterCount() + " chapters is saved successfully.";
    }
}
