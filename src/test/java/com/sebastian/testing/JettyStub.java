package com.sebastian.testing;

import java.net.URI;
import java.nio.file.Path;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.PathResource;

/**
 * inicia jetty para las pruebas.
 * 
 * @author Sebastián Ávila A.
 *
 */
public class JettyStub {
  private Server server;

  public URI start() throws Exception {
    server = createServer(8080);
    server.setStopAtShutdown(true);
    server.start();
    return server.getURI();
  }

  public void stop() throws Exception {
    server.stop();
  }

  public static Server createServer(int port) throws Exception {
    final var br =
        new PathResource(Path.of(System.getProperty("user.dir") + "/target/test-classes"));
    final var server = new Server(port);
    final var rh = new ResourceHandler();
    rh.setDirectoriesListed(true);
    rh.setBaseResource(br);
    final var handlers = new HandlerList();
    handlers.setHandlers(new Handler[] {rh});
    server.setHandler(handlers);
    return server;
  }
}
