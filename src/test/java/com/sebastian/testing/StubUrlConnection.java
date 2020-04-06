package com.sebastian.testing;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * implementation of the HttpURLConnection class so that we can return any value we want for the
 * test.
 */
public class StubUrlConnection extends HttpURLConnection {

  private boolean isInput = true;

  protected StubUrlConnection(URL url) {
    super(url);
  }

  public InputStream getInputStream() throws IOException {
    if (!isInput) {
      throw new ProtocolException(
          "Cannot read from URLConnection" + " if doInput=false (call setDoInput(true))");

    }
    ByteArrayInputStream readStream = new ByteArrayInputStream(new String("It works").getBytes());
    return readStream;
  }

  public void connect() throws IOException {}

  public void disconnect() {}

  public boolean usingProxy() {
    return false;
  }
}
