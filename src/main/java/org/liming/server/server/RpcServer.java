package org.liming.server.server;

/**
 * ClassName: RpcServer
 * Package: org.liming.server.server
 * Description:
 *
 * @Author
 * @Create 2025-01-03 9:22 PM
 * @Version 1.0
 */
public interface RpcServer {
  //start listening
  void start(int port);
  void stop();
}
