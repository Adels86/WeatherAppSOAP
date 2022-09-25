package net.atos.weatherSoap.demo.model;

import lombok.Getter;
import net.atos.weatherSoap.demo.model.webClientModel.Clouds;
import net.atos.weatherSoap.demo.model.webClientModel.Main;
import net.atos.weatherSoap.demo.model.webClientModel.Weather;
import java.util.List;

@Getter
public class WeatherFromClient {
    private Clouds clouds;
    private Main main;
    private List<Weather> weather;
    private String name;

}
