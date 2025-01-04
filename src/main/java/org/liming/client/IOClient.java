package org.liming.client;

import org.liming.common.message.RpcRequest;
import org.liming.common.message.RpcResponse;
import org.liming.server.provider.ServiceProvider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * ClassName: IOClient
 * Package: org.liming.client
 * Description:
 *
 * @Author
 * @Create 2025-01-03 10:00 PM
 * @Version 1.0
 */
public class IOClient {
  public static RpcResponse sendRequest(String host, int port, RpcRequest request) {
    try {
      Socket socket = new Socket(host, port);
      ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

      oos.writeObject(request);
      oos.flush();

      RpcResponse response = (RpcResponse) ois.readObject();
      return response;
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }
}
