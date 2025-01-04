package org.liming.server.provider;

import java.security.Provider;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: ServiceProvider
 * Package: org.liming.server.provider
 * Description:
 *
 * @Author
 * @Create 2025-01-03 9:23 PM
 * @Version 1.0
 */

//local server storage
public class ServiceProvider {
  private Map<String, Object> interfaceProvider;

  public ServiceProvider() {
    this.interfaceProvider = new HashMap<>();
  }

  public void provideServiceInterface(Object service) {
    String serviceName = service.getClass().getName();
    Class<?>[] interfaceName = service.getClass().getInterfaces();

    for(Class<?> clazz : interfaceName) {
      interfaceProvider.put(clazz.getName(), service);
    }
  }

  //get service instance
  public Object getService(String interfaceName) {
    return interfaceProvider.get(interfaceName);
  }
}
