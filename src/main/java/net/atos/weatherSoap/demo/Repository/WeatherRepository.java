package net.atos.weatherSoap.demo.Repository;

import com.example.demo.WeatherFault;
import com.example.demo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import net.atos.weatherSoap.demo.Service.CityService;
import net.atos.weatherSoap.demo.exception.CityNotFoundException;
import net.atos.weatherSoap.demo.exception.UserOrderNotFoundException;
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


//    @PostConstruct
//    public void initData(){
//        temps.put("Berlin", 20.0);
//    }

    public double getTemp(String city) {

        City result = cityRepository.findByName(city);
        log.info("" + result.getLon());
        if (result == null) {
            throw new CityNotFoundException(result.getName());
        }
        OpenWeather weatherFromApi = weatherClient.getWeatherForCoordinates( result.getLat(),result.getLon());
        if (weatherFromApi == null) {
            try {
                throw new WeatherFault("could not find ", city);
            } catch (WeatherFault e) {
                throw new UserOrderNotFoundException(city);
            }
        }
        return weatherFromApi.getTempCelsius();
    }


}
