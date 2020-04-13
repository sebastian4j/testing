package com.sebastian.testing.stub;

import com.sebastian.testing.JettyStub;
import com.sebastian.testing.WebClient;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.MalformedURLException;
import java.net.URI;
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
	/** uri en la que responde el server. */
  private static URI uri;

  @BeforeAll
  public static void beforeAll() throws Exception {
    uri = JS.uri();
  }

  @AfterAll
  public static void afterAll() throws Exception {
    JS.stop();
  }

  @Test
  public void obtengoElContenidoEsperado() throws MalformedURLException {
    WebClient client = new WebClient();		
    String json = client.getContent(uri.resolve("demo.json").toURL());
    assertEquals("{\"a\":\"b\",\"c\":\"d\"}", json);
  }
}
