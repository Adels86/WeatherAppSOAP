package net.atos.weatherSoap.demo.Service;

import net.atos.weatherSoap.demo.model.Entity.City;
import net.atos.weatherSoap.demo.model.OpenWeather;


public interface CityService {
    OpenWeather getWeatherFromApi(double lon, double lat);

    City getById(int id);



}
