
package com.example.demo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WeatherWSDLFilePortType", targetNamespace = "http://atos.net/WeatherWSDLFile/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WeatherWSDLFilePortType {


    /**
     * 
     * @param city
     * @param id
     * @return
     *     returns java.lang.Double
     * @throws WeatherFaultMessage
     */
    @WebMethod(operationName = "WeatherRequest", action = "WeatherRequest")
    @WebResult(name = "temperature", targetNamespace = "")
    @RequestWrapper(localName = "WeatherRequest", targetNamespace = "http://atos.net/WeatherWSDLFile/", className = "com.example.demo.WeatherRequest")
    @ResponseWrapper(localName = "WeatherResponse", targetNamespace = "http://atos.net/WeatherWSDLFile/", className = "com.example.demo.WeatherResponse")
    public Double weatherRequest(
        @WebParam(name = "city", targetNamespace = "")
        String city,
        @WebParam(name = "id", targetNamespace = "")
        Integer id)
        throws WeatherFaultMessage
    ;

}