package org.liming.client.proxy;

import lombok.AllArgsConstructor;
import org.liming.client.IOClient;
import org.liming.common.message.RpcRequest;
import org.liming.common.message.RpcResponse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName: ClientProxy
 * Package: org.liming.client
 * Description:
 *
 * @Author
 * @Create 2025-01-03 9:02 PM
 * @Version 1.0
 */

@AllArgsConstructor
public class ClientProxy implements InvocationHandler {
  private String host;
  private int port;

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //create request
    RpcRequest request = RpcRequest.builder()
            .interfaceName(method.getDeclaringClass().getName())
            .methodName(method.getName())
            .params(args).paramsType(method.getParameterTypes()).build();

    //IOClient.sendRequest
    RpcResponse response = IOClient.sendRequest(host, port, request);
    return response.getData();
  }

  public <T>T getProxy(Class<T> clazz) {
    Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
    return (T)o;
  }
}
