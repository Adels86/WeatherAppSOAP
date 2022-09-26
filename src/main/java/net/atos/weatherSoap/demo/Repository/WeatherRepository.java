package net.atos.weatherSoap.demo.Repository;

import lombok.extern.slf4j.Slf4j;
import net.atos.weatherSoap.demo.model.Entity.City;
import net.atos.weatherSoap.demo.model.OpenWeather;
import net.atos.weatherSoap.demo.weatherclient.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WeatherRepository {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    WeatherClient weatherClient;

    public double getTemp(String city) {
        City result = cityRepository.findByName(city);
        OpenWeather weatherFromApi = weatherClient.getWeatherForCoordinates(result.getLat(), result.getLon());
        return weatherFromApi.getTempCelsius();
    }


}
