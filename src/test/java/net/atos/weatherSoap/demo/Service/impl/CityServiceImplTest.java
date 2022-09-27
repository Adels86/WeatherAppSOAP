package net.atos.weatherSoap.demo.Service.impl;

import net.atos.weatherSoap.demo.Repository.CityRepository;
import net.atos.weatherSoap.demo.model.Entity.City;
import net.atos.weatherSoap.demo.model.OpenWeather;
import net.atos.weatherSoap.demo.weatherclient.WeatherClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CityServiceImplTest {
    @Mock
    private CityRepository cityRepository;
    @Mock
    private WeatherClient weatherClient;

    @InjectMocks
    private CityServiceImpl cityService;

    @Test
    public void shouldReturnCorrectCityById() {
        //given
        City city = new City(2, "Warsaw", 21.012, 52.230);
        Mockito.when(cityRepository.findById(any())).thenReturn(Optional.of(city));
        //when
        City result = cityService.getById(1);
        //then
        assertThat(result).isEqualTo(city);
    }

    @Test
    public void shouldReturnCorrectWeather() {
        //given
        OpenWeather warsawWeather = OpenWeather.builder().all(12).temp(22).name("Warsaw").build();
        //when
        Mockito.when(weatherClient.getWeatherForCoordinates(21.012, 52.230)).thenReturn(warsawWeather);
        OpenWeather result = cityService.getWeatherFromApi(21.012, 52.230);
        //then
        assertThat(result).isEqualTo(warsawWeather);

    }

}