package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestCase {
    String title;
    String description;
    String preConditions;
    String postConditions;
}
