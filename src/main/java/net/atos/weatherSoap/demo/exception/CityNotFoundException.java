package net.atos.weatherSoap.demo.exception;

public class CityNotFoundException extends RuntimeException {


    public CityNotFoundException(String name) {
        super("Could not find city " + name);
    }
}
