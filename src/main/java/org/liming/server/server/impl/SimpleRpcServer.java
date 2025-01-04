package org.liming.server.server.impl;

import lombok.AllArgsConstructor;
import org.liming.server.provider.ServiceProvider;
import org.liming.server.server.RpcServer;
import org.liming.server.server.work.WorkThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName: SimpleRpcServer
 * Package: org.liming.server.server.impl
 * Description:
 *
 * @Author
 * @Create 2025-01-03 9:20 PM
 * @Version 1.0
 */

@AllArgsConstructor
public class SimpleRpcServer implements RpcServer {
  private ServiceProvider serviceProvider;

  @Override
  public void start(int port) {
    try {
      ServerSocket serverSocket = new ServerSocket(port);
      System.out.println("server started");
      while(true) {
        Socket socket = serverSocket.accept();
        new Thread(new WorkThread(socket, serviceProvider)).start();
      }
    }catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void stop() {

  }
}
