package dto;

import com.github.javafaker.Faker;

public class ProjectFactory {

    public static Project getRandom() {
        Faker faker = new Faker();
        return Project.builder()
                .title(faker.ancient().god())
                .code(faker.ancient().god().toUpperCase())
                .description(faker.ancient().hero())
                .access_type("public")
                .build();
    }
}