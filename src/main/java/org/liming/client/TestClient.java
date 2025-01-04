package org.liming.client;

import org.liming.client.proxy.ClientProxy;
import org.liming.common.pojo.User;
import org.liming.common.service.UserService;

/**
 * ClassName: TestClient
 * Package: org.liming.client
 * Description:
 *
 * @Author
 * @Create 2025-01-03 9:48 PM
 * @Version 1.0
 */
public class TestClient {
  public static void main(String[] args) {
    ClientProxy clientProxy = new ClientProxy("127.0.0.1", 9999);
    UserService proxy = clientProxy.getProxy(UserService.class);

    User user = proxy.getUserByUserId(1);
    System.out.println("get user from server = " + user.toString());

    User user1 = User.builder().id(100).userName("zlm").sex(true).build();
    Integer id = proxy.insertUserId(user1);
    System.out.println("insert a user id to server " + id);
  }
}
