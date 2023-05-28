package dto;

import com.github.javafaker.Faker;

public class TestCaseFactory {

    public static TestCase getRandom() {
        Faker faker = new Faker();
        return TestCase.builder()
                .title(faker.book().title())
                .description(faker.book().genre())
                .preConditions("Test")
                .postConditions("Test")
                .build();
    }
}