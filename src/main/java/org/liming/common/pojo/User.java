package org.liming.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: User
 * Package: org.liming.common.pojo
 * Description:
 *
 * @Author
 * @Create 2025-01-03 9:53 PM
 * @Version 1.0
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
  private Integer id;
  private String userName;
  private Boolean sex;
}
