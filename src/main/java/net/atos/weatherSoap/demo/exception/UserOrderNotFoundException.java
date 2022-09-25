package net.atos.weatherSoap.demo.exception;

import net.atos.weatherSoap.demo.model.UserOrder;


public class UserOrderNotFoundException extends RuntimeException {
    public UserOrderNotFoundException() {
        super("couldn't find cities");
    }



}
