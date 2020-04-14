package com.sebastian.testing.stub.jetty;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet con mensaje para pruebas.
 * 
 * @author Sebastián Ávila A.
 *
 */
public class HelloServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    res.getOutputStream().print("""
        {"hola": "chao"}""");
  }
}
