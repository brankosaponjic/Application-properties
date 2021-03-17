package brankosaponjic.course.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("course")
@Getter
@Setter
public class CourseConfiguration {

    private String name;
    private int chapterCount;
    private int rating;
    private String author;
}
