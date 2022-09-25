
package com.example.demo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.demo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _WeatherFault_QNAME = new QName("http://atos.net/WeatherWSDLFile/", "weatherFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.demo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WeatherRequest }
     * 
     */
    public WeatherRequest createWeatherRequest() {
        return new WeatherRequest();
    }

    /**
     * Create an instance of {@link WeatherResponse }
     * 
     */
    public WeatherResponse createWeatherResponse() {
        return new WeatherResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://atos.net/WeatherWSDLFile/", name = "weatherFault")
    public JAXBElement<String> createWeatherFault(String value) {
        return new JAXBElement<String>(_WeatherFault_QNAME, String.class, null, value);
    }

}
