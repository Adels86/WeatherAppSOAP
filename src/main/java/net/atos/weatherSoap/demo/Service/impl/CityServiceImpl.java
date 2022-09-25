package net.atos.weatherSoap.demo.Service.impl;
import lombok.extern.slf4j.Slf4j;
import net.atos.weatherSoap.demo.Repository.CityRepository;
import net.atos.weatherSoap.demo.Service.CityService;
import net.atos.weatherSoap.demo.exception.CityNotFoundException;
import net.atos.weatherSoap.demo.model.Entity.City;
import net.atos.weatherSoap.demo.model.OpenWeather;
import net.atos.weatherSoap.demo.weatherclient.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherClient weatherClient;

    @Override
    public OpenWeather getWeatherFromApi(double lon, double lat) {
        return weatherClient.getWeatherForCoordinates(lon, lat);
    }
    @Override
    public City getById(int id){
        return cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException("city id: " + id));
    }




}
