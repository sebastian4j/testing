package com.sebastian.testing.stub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.sebastian.testing.WebClient;

/**
 * desactivarlo para StubJettyTest.
 *
 * tendra que ser más complejo cuando se utilizan otros métodos (+++ para jetty)
 */
@Disabled
public class StubUrlConnectionTest {
  @BeforeAll
  public static void setUp() {
    /** custom url protocol handler */
    URL.setURLStreamHandlerFactory((protocol) -> {
      return new URLStreamHandler() {
        @Override
        protected URLConnection openConnection(URL u) throws IOException {
          return new StubUrlConnection(u);
        }
      };
    });
  }

  @Test
  public void testGetContentOk() throws MalformedURLException {
    WebClient client = new WebClient();
    String workingContent = client.getContent(new URL("http://localhost"));
    assertEquals("It works", workingContent);
  }

}
