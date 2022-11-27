package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@ActiveProfiles("snake")
@JsonTest
public class BeerDtoSnakeTest extends BaseTest {
    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();
        String jsonString = objectMapper.writeValueAsString(beerDto);
        log.debug("json: " + jsonString);
    }

    @Test
    void testDeserlize() throws JsonProcessingException {
        String json = """
                {
                    "id":"99f5c99e-9ef2-41c9-80f4-2d85e8b707df",
                    "beer_name":"Lucky Jack",
                    "beer_style":"American Pale Ale",
                    "upc":7072712000121,
                    "price":30,
                    "created_date":"2022-11-27 08:04:57+0100",
                    "last_updated_date":"2022-11-26T16:54:17.240056103+01:00",
                    "lastUpdatedDate":"2022-11-26T16:39:13.611179054+01:00",
                    "my_local_date": "20221127"
                }
                """;

        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);
        log.debug("BeerDto: " + beerDto.toString());
    }
}
