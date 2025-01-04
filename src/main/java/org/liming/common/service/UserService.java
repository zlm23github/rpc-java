package org.liming.common.service;

import org.liming.common.pojo.User;

/**
 * ClassName: UserService
 * Package: org.liming.common.service
 * Description:
 *
 * @Author
 * @Create 2025-01-03 9:52 PM
 * @Version 1.0
 */
public interface UserService {
  User getUserByUserId(Integer id);
  Integer insertUserId(User user);
}
