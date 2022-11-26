package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

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
                    "id":"d10b5607-a337-4b98-a9af-3a26b2cb62d2", 
                    "beerName":"Lucky Jack", 
                    "beerStyle":"American Pale Ale", 
                    "upc":7072712000121, 
                    "price":39, 
                    "createdDate":"2022-11-26T16:39:13.611144339+01:00", 
                    "lastUpdatedDate":"2022-11-26T16:39:13.611179054+01:00"
                }
                """;
        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);
        log.debug("BeerDto: " + beerDto.toString());
    }
}