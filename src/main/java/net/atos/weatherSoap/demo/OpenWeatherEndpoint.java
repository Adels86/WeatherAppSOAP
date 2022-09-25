package net.atos.weatherSoap.demo;
import com.example.demo.WeatherRequest;
import com.example.demo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import net.atos.weatherSoap.demo.Repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Slf4j
@Endpoint
public class OpenWeatherEndpoint {
    private final WeatherRepository weatherRepository;
    @Autowired
    public OpenWeatherEndpoint(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }
    @PayloadRoot(namespace = "http://atos.net/WeatherWSDLFile/", localPart = "WeatherRequest")
    @ResponsePayload
    public WeatherResponse getWeather(@RequestPayload WeatherRequest request){
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setTemperature(weatherRepository.getTemp(request.getCity()));

        return weatherResponse;
    }
}
