package com.sebastian.testing.stub;

import com.sebastian.testing.JettyStub;
import com.sebastian.testing.WebClient;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * test unitario + integración.
 * 
 * no usar stub cuando se necesita un detallado control o causa del problema
 * 
 * @author Sebastián Ávila A.
 *
 */
public class StubJettyTest {
  private static final JettyStub JS = new JettyStub();
  private static URI uri;

  @BeforeAll
  public static void setUp() throws Exception {
    uri = JS.start();
  }

  @AfterAll
  public static void tearDown() throws Exception {
    JS.stop();
  }

  @Test
  public void obtengoElContenidoEsperado() throws MalformedURLException {
    WebClient client = new WebClient();
    String json = client.getContent(new URL(uri.toString() + "demo.json"));
    assertEquals("{\"a\":\"b\",\"c\":\"d\"}", json);
  }
}
