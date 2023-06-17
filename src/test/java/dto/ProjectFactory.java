package dto;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProjectFactory {

    public static Project getRandom() {
        Faker faker = new Faker();
        log.info("Create project by project factory");
        return Project.builder()
                .title(faker.name().firstName())
                .code(faker.name().firstName().toUpperCase())
                .description(faker.ancient().hero())
                .access_type("public")
                .build();
    }
}