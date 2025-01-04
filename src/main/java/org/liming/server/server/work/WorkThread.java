package org.liming.server.server.work;

import lombok.AllArgsConstructor;
import org.liming.common.message.RpcRequest;
import org.liming.common.message.RpcResponse;
import org.liming.server.provider.ServiceProvider;

import javax.print.attribute.standard.JobKOctets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.NoSuchElementException;

/**
 * ClassName: WorkThread
 * Package: org.liming.server.server.work
 * Description:
 *
 * @Author
 * @Create 2025-01-03 9:26 PM
 * @Version 1.0
 */
@AllArgsConstructor
public class WorkThread implements Runnable{
  private Socket socket;
  private ServiceProvider serviceProvider;
  @Override
  public void run() {
    try {
      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
      //read request from client
      RpcRequest rpcRequest = (RpcRequest) ois.readObject();
      //get response by reflection
      RpcResponse rpcResponse = getResponse(rpcRequest);
      //write response to client
      oos.writeObject(rpcResponse);
      oos.flush();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private RpcResponse getResponse(RpcRequest rpcRequest) {
    String interfaceName = rpcRequest.getInterfaceName();
    Object service = serviceProvider.getService(interfaceName);
    Method method = null;
    try {
      method = service.getClass().getMethod(rpcRequest.getMethodName(), rpcRequest.getParamsType());
      Object invoke = method.invoke(service, rpcRequest.getParams());
      return RpcResponse.success(invoke);
    } catch (NoSuchElementException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      e.printStackTrace();
      return RpcResponse.fail();
    }
  }
}
