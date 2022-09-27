package net.atos.weatherSoap.demo.controller;

import com.example.demo.WeatherFaultMessage;
import com.example.demo.WeatherRequest;
import com.example.demo.WeatherResponse;
import net.atos.weatherSoap.demo.Repository.WeatherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class OpenWeatherEndpointTest {

    @Mock
    WeatherRepository weatherRepository;


    @InjectMocks
    OpenWeatherEndpoint openWeatherEndpoint;

    @Test
    public void shouldReturnCoerrectTemp() {
        //given
        WeatherRequest weatherRequest = new WeatherRequest();
        weatherRequest.setCity("Warsaw");

        Mockito.when(weatherRepository.getTemp(any())).thenReturn(25.0);

//        WeatherResponse response = new WeatherResponse();
//        response.setTemperature(weatherRepository.getTemp(weatherRequest.getCity()));


        //when
        try {
            WeatherResponse weather = openWeatherEndpoint.getWeather(weatherRequest);
        //then
            assertEquals(25.0, weather.getTemperature());
        } catch (WeatherFaultMessage e) {
            throw new RuntimeException(e);
        }
    }

}