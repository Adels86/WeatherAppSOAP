package net.atos.weatherSoap.demo.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OpenWeather {
    private int all;
    private float temp;
    private float tempCelsius;
    private String description;
    private String icon;
    private String name;
}
