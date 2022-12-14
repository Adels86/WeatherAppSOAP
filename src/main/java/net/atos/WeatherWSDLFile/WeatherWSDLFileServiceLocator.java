/**
 * WeatherWSDLFileServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.atos.WeatherWSDLFile;

public class WeatherWSDLFileServiceLocator extends org.apache.axis.client.Service implements net.atos.WeatherWSDLFile.WeatherWSDLFileService {

    public WeatherWSDLFileServiceLocator() {
    }


    public WeatherWSDLFileServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WeatherWSDLFileServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WeatherWSDLFileSOAP
    private java.lang.String WeatherWSDLFileSOAP_address = "http://localhost:8080/WeatherWSDLFile/";

    public java.lang.String getWeatherWSDLFileSOAPAddress() {
        return WeatherWSDLFileSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WeatherWSDLFileSOAPWSDDServiceName = "WeatherWSDLFileSOAP";

    public java.lang.String getWeatherWSDLFileSOAPWSDDServiceName() {
        return WeatherWSDLFileSOAPWSDDServiceName;
    }

    public void setWeatherWSDLFileSOAPWSDDServiceName(java.lang.String name) {
        WeatherWSDLFileSOAPWSDDServiceName = name;
    }

    public net.atos.WeatherWSDLFile.WeatherWSDLFilePortType getWeatherWSDLFileSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WeatherWSDLFileSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWeatherWSDLFileSOAP(endpoint);
    }

    public net.atos.WeatherWSDLFile.WeatherWSDLFilePortType getWeatherWSDLFileSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.atos.WeatherWSDLFile.WeatherWSDLFileSOAPStub _stub = new net.atos.WeatherWSDLFile.WeatherWSDLFileSOAPStub(portAddress, this);
            _stub.setPortName(getWeatherWSDLFileSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWeatherWSDLFileSOAPEndpointAddress(java.lang.String address) {
        WeatherWSDLFileSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.atos.WeatherWSDLFile.WeatherWSDLFilePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                net.atos.WeatherWSDLFile.WeatherWSDLFileSOAPStub _stub = new net.atos.WeatherWSDLFile.WeatherWSDLFileSOAPStub(new java.net.URL(WeatherWSDLFileSOAP_address), this);
                _stub.setPortName(getWeatherWSDLFileSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WeatherWSDLFileSOAP".equals(inputPortName)) {
            return getWeatherWSDLFileSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://atos.net/WeatherWSDLFile/", "WeatherWSDLFileService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://atos.net/WeatherWSDLFile/", "WeatherWSDLFileSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WeatherWSDLFileSOAP".equals(portName)) {
            setWeatherWSDLFileSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
