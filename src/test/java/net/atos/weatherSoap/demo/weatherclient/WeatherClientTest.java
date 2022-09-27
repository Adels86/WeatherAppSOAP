package net.atos.weatherSoap.demo.weatherclient;


import net.atos.weatherSoap.demo.Repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;



import static org.junit.jupiter.api.Assertions.*;

class WeatherClientTest {

    private WeatherClient weatherClient;

    @BeforeEach
    void setUp() {
        weatherClient = new WeatherClient();
    }

    @Value("${api_url}")
    private String url;
    @Value("${api_key}")
    private String apiKey;

    @Value("${icon_key}")
    private String iconUrl;


    @Test
    public void shouldReturnCorrectUri() {
        //given
        double lat = 100;
        double lon = 100;
        String result = url + "weather?lat=100.0&lon=100.0&appid=" + apiKey;

        //when
        String uri = weatherClient.getUri(lat, lon);

        //then
        assertEquals(result, uri);
    }

    @Test
    public void shouldReturnCorrectIconUri() {
        //given
        String code = "CODE";
        String result = iconUrl + "CODE@2x.png";

        //when
        String uri = weatherClient.getIconUri(code);

        //then
        assertEquals(result, uri);
    }

    @Test
    public void weatherTest(){

    }

}