package net.atos.weatherSoap.demo.exception;

import net.atos.weatherSoap.demo.model.UserOrder;


public class UserOrderNotFoundException extends RuntimeException {
    public UserOrderNotFoundException(String name) {
        super("Could not find order from user: " + name);
    }



}
