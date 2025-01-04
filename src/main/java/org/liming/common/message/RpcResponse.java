package org.liming.common.message;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: RpcResponse
 * Package: org.liming.common.message
 * Description:
 *
 * @Author
 * @Create 2025-01-03 8:56 PM
 * @Version 1.0
 */

@Data
@Builder
public class RpcResponse implements Serializable {
  //status code
  private int code;
  //status message
  private String message;
  //data
  private Object data;
  //success message
  public static RpcResponse success(Object data) {
    return RpcResponse.builder().code(200).data(data).build();
  }

  //fail message
  public static RpcResponse fail() {
    return RpcResponse.builder().code(500).message("Server Error").build();
  }
}
