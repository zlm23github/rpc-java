package org.liming.common.service.impl;

import org.liming.common.pojo.User;
import org.liming.common.service.UserService;

import java.util.Random;
import java.util.UUID;

/**
 * ClassName: UserServiceImpl
 * Package: org.liming.common.service.impl
 * Description:
 *
 * @Author
 * @Create 2025-01-03 9:52 PM
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {
  @Override
  public User getUserByUserId(Integer id) {
    System.out.println("Client searched " + id + " user");
    Random random = new Random();
    User user = User.builder().userName(UUID.randomUUID().toString()).id(id)
            .sex(random.nextBoolean()).build();
    return user;
  }

  @Override
  public Integer insertUserId(User user) {
    System.out.println("Insert data success: " + user.getUserName());
    return user.getId();
  }
}
