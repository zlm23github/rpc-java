package org.liming.server;

import org.liming.common.service.UserService;
import org.liming.common.service.impl.UserServiceImpl;
import org.liming.server.provider.ServiceProvider;
import org.liming.server.server.RpcServer;
import org.liming.server.server.impl.SimpleRpcServer;

/**
 * ClassName: TestServer
 * Package: org.liming.server
 * Description:
 *
 * @Author
 * @Create 2025-01-03 9:20 PM
 * @Version 1.0
 */
public class TestServer {
  public static void main(String[] args) {
    UserService userService = new UserServiceImpl();

    ServiceProvider serviceProvider = new ServiceProvider();
    serviceProvider.provideServiceInterface(userService);

    RpcServer rpcServer = new SimpleRpcServer(serviceProvider);
    rpcServer.start(9999);
  }
}
