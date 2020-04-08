package com.sebastian.testing.mock;

import java.io.InputStream;

public class WebClient {
  public String getContent(ConnectionFactory connectionFactory) {
    String workingContent;
    StringBuilder content = new StringBuilder();
    try (InputStream is = connectionFactory.getData()) {
      int count;
      while (-1 != (count = is.read())) {
        content.append(new String(Character.toChars(count)));
      }
      workingContent = content.toString();
    } catch (Exception e) {
			e.printStackTrace();
      workingContent = null;
    }
    return workingContent;
  }
}
