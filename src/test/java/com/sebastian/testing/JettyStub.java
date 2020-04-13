package com.sebastian.testing;

import java.net.URI;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;
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

  public URI uri() throws Exception {
    crearServer(ThreadLocalRandom.current().nextInt(10000, 20000));
    server.setStopAtShutdown(true);
    server.start();
    return server.getURI();
  }

  public void stop() throws Exception {
    server.stop();
  }

  private void crearServer(int port) throws Exception {
    final var br =
        new PathResource(Path.of(System.getProperty("user.dir") + "/target/test-classes"));
    server = new Server(port);
    final var rh = new ResourceHandler();
    rh.setDirectoriesListed(true);
    rh.setBaseResource(br);
    final var handlers = new HandlerList();
    handlers.setHandlers(new Handler[] {rh});
    server.setHandler(handlers);
  }
}
