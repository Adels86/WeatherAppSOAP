package net.atos.WeatherWSDLFile;

public class WeatherWSDLFilePortTypeProxy implements net.atos.WeatherWSDLFile.WeatherWSDLFilePortType {
  private String _endpoint = null;
  private net.atos.WeatherWSDLFile.WeatherWSDLFilePortType weatherWSDLFilePortType = null;
  
  public WeatherWSDLFilePortTypeProxy() {
    _initWeatherWSDLFilePortTypeProxy();
  }
  
  public WeatherWSDLFilePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initWeatherWSDLFilePortTypeProxy();
  }
  
  private void _initWeatherWSDLFilePortTypeProxy() {
    try {
      weatherWSDLFilePortType = (new net.atos.WeatherWSDLFile.WeatherWSDLFileServiceLocator()).getWeatherWSDLFileSOAP();
      if (weatherWSDLFilePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)weatherWSDLFilePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)weatherWSDLFilePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (weatherWSDLFilePortType != null)
      ((javax.xml.rpc.Stub)weatherWSDLFilePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.atos.WeatherWSDLFile.WeatherWSDLFilePortType getWeatherWSDLFilePortType() {
    if (weatherWSDLFilePortType == null)
      _initWeatherWSDLFilePortTypeProxy();
    return weatherWSDLFilePortType;
  }
  
  public double weatherRequest(java.lang.String city, int id) throws java.rmi.RemoteException, net.atos.WeatherWSDLFile.WeatherFault{
    if (weatherWSDLFilePortType == null)
      _initWeatherWSDLFilePortTypeProxy();
    return weatherWSDLFilePortType.weatherRequest(city, id);
  }
  
  
}