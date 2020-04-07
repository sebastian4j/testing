package com.sebastian.testing.mock;

import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestWebClient {

  @Test
  public void testGetContentOk() throws Exception {
    MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();

    mockConnectionFactory.setData(new ByteArrayInputStream("It works".getBytes()));

    // pruebo la lógica del método getContent
    // pero la clase agregada HttpURLConnectionFactory
    // queda sin test
    WebClient client = new WebClient();
    String workingContent = client.getContent(mockConnectionFactory);

    assertEquals("It works", workingContent);
  }

  @Test
  @DisplayName("mock con Expectation")
  public void testGetContentOkMockInputStream() throws Exception {
    MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();
    MockInputStream mockStream = new MockInputStream();
    mockStream.setBuffer("It works");
    mockConnectionFactory.setData(mockStream);
    WebClient client = new WebClient();
    String workingContent = client.getContent(mockConnectionFactory);
    assertEquals("It works", workingContent);
    mockStream.verify();
  }
}