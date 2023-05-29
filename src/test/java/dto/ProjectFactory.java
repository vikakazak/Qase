package dto;

import com.github.javafaker.Faker;

public class ProjectFactory {

    public static Project getRandom() {
        Faker faker = new Faker();
        return Project.builder()
                .title(faker.name().firstName())
                .code(faker.name().firstName().toUpperCase())
                .description(faker.ancient().hero())
                .access_type("public")
                .build();
    }
}