package net.atos.weatherSoap.demo.controller;

import lombok.extern.slf4j.Slf4j;
import net.atos.weatherSoap.demo.Service.CityService;
import net.atos.weatherSoap.demo.exception.UserOrderNotFoundException;
import net.atos.weatherSoap.demo.model.OpenWeather;
import net.atos.weatherSoap.demo.model.UserOrder;
import net.atos.weatherSoap.demo.weatherclient.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class WeatherController {

    private UserOrder userOrder;
    @Autowired
    private CityService cityService;

    @Autowired
    WeatherClient weatherClient;

    @GetMapping(path = "/cities")
    public String citieList(ModelMap modelMap) {
        modelMap.addAttribute("emptyOrder", new UserOrder());
        return "index";
    }
    @PostMapping("/cities")
    public String handleNewOrder(@ModelAttribute UserOrder userOrderFromUser) {
        log.info("Received user: " + userOrderFromUser);
        this.userOrder = userOrderFromUser;
        return "redirect:/order";
    }
    @GetMapping(path = "/order")
    public String getOrders(ModelMap modelMap) {
        if (userOrder == null) {
            throw new UserOrderNotFoundException();
        }
        List<OpenWeather> openWeathers = getWeatherByCoordinates();
        List<OpenWeather> orderedWeathers = new ArrayList<>();

        if (!(userOrder.getZocca() == null)) {
            orderedWeathers.add(openWeathers.get(0));
        }
        if (!(userOrder.getWarsaw() == null)) {
            orderedWeathers.add(openWeathers.get(1));
        }
        if (!(userOrder.getLondon() == null)) {
            orderedWeathers.add(openWeathers.get(2));
        }
        if (!(userOrder.getParis() == null)) {
            orderedWeathers.add(openWeathers.get(3));
        }
        if (!(userOrder.getRome() == null)) {
            orderedWeathers.add(openWeathers.get(4));
        }
        if (!(userOrder.getMadrid() == null)) {
            orderedWeathers.add(openWeathers.get(6));
        }
        if (!(userOrder.getBerlin() == null)) {
            orderedWeathers.add(openWeathers.get(7));
        }
        if (!(userOrder.getTokio() == null)) {
            orderedWeathers.add(openWeathers.get(8));
        }
        if (!(userOrder.getSydney() == null)) {
            orderedWeathers.add(openWeathers.get(9));
        }
        if (orderedWeathers.isEmpty()) {
            throw new UserOrderNotFoundException();
        }

        modelMap.addAttribute("orderedWeathers", orderedWeathers);
        return "order";
    }

    private List<OpenWeather> getWeatherByCoordinates() {
        List<OpenWeather> openWeathers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            openWeathers.add(cityService.getWeatherFromApi(cityService.getById(i).getLat(), cityService.getById(i).getLon()));
        }
        return openWeathers;
    }
}


