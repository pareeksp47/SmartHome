package com.exchange.isep.builder;

import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@Component
public class ReqBuilder {

  /**
   * Request builder get
   * @param api
   * @return
   */
  public RequestBuilder get(String api) {

    return MockMvcRequestBuilders.get(api);

  }

  /**
   * Request builder post
   * @param api
   * @return
   */
  public RequestBuilder post(String api) {

    return MockMvcRequestBuilders.post(api);

  }

  /**
   * Request builder put
   * @param api
   * @return
   */
  public RequestBuilder put(String api) {

    return MockMvcRequestBuilders.put(api);

  }

  /**
   * Request builder delete
   * @param api
   * @return
   */
  public RequestBuilder delete(String api) {

    return MockMvcRequestBuilders.delete(api);

  }
}