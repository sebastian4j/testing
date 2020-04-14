package com.sebastian.testing.stub.jetty;

import java.net.URI;
import java.nio.file.Path;
import java.util.concurrent.ThreadLocalRandom;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
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
    server = new Server(port);
    
    // definir recursos desde el sistema de archivos
    final var rh = new ResourceHandler();
    rh.setDirectoriesListed(true);
    rh.setBaseResource(new PathResource(
        Path.of(System.getProperty("user.dir")).resolve("target/test-classes")));
    
    // definir servlets
    final var sh = new ServletHandler();        
    sh.addServletWithMapping(new ServletHolder(new HelloServlet()), "/hello/*");
    
    // agregar los handlers
    server.setHandler(new HandlerList(rh, sh));
  }
}
