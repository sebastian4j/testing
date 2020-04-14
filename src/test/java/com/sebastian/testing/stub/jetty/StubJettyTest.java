package com.sebastian.testing.stub.jetty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.MalformedURLException;
import java.net.URI;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.sebastian.testing.WebClient;

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
  public void obtengoElContenidoEsperadoDesdeServlet() throws MalformedURLException {
    WebClient client = new WebClient();     
    var json = client.getContent(uri.resolve("/hello").toURL());
    assertEquals("""
        {"hola": "chao"}""", json);
    json = client.getContent(uri.resolve("/hello?a=b").toURL());
    assertEquals("""
        {"hola": "chao"}""", json);
  }
  
  @Test
  public void obtengoElContenidoEsperadoDesdeArchivo() throws MalformedURLException {
    WebClient client = new WebClient();		
    String json = client.getContent(uri.resolve("demo.json").toURL());
    assertEquals("""
            {"a":"b","c":"d"}""", json);
  }
}
