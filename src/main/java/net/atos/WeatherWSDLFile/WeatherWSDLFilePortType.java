/**
 * WeatherWSDLFilePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.atos.WeatherWSDLFile;

public interface WeatherWSDLFilePortType extends java.rmi.Remote {
    public double weatherRequest(java.lang.String city, int id) throws java.rmi.RemoteException, net.atos.WeatherWSDLFile.WeatherFault;
}
