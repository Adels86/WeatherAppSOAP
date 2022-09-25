package net.atos.weatherSoap.demo.weatherclient;
import net.atos.weatherSoap.demo.model.OpenWeather;
import net.atos.weatherSoap.demo.model.WeatherFromClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {
    @Value("${api_url}")
    private String url;
    @Value("${api_key}")
    private String apiKey;

    @Value("${icon_key}")
    private String iconUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public OpenWeather getWeatherForCoordinates(double lat, double lon) {
        WeatherFromClient weatherFromeClient = restTemplate.getForObject(getUri(lat,lon),
                WeatherFromClient.class);

        return OpenWeather.builder()
                .all(weatherFromeClient.getClouds().getAll())
                .temp(weatherFromeClient.getMain().getTemp())
                .tempCelsius(kelvinToCelsiusConverter(weatherFromeClient.getMain().getTemp()))
                .description(weatherFromeClient.getWeather().get(0).getDescription())
                .icon(getIconUri(weatherFromeClient.getWeather().get(0).getIcon()))
                .name(weatherFromeClient.getName())
                .build();
    }

    public String getUri(double lat, double lon){
        return url + "weather?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;
    }

    public String getIconUri(String code){
       return  iconUrl + code + "@2x.png";
    }

    public float kelvinToCelsiusConverter(float kel){
        return Math.round(kel -= 273.15);
    }
}
