package org.liming.common.message;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: RpcRequest
 * Package: org.liming.common.message
 * Description:
 *
 * @Author
 * @Create 2025-01-03 8:53 PM
 * @Version 1.0
 */

@Data
@Builder
public class RpcRequest implements Serializable {
  //service class name
  private String interfaceName;

  private String methodName;
  //parameters
  private Object[] params;
  //parameter types
  private Class<?>[] paramsType;
}
