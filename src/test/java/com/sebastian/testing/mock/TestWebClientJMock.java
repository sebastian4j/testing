package com.sebastian.testing.mock;

import java.io.IOException;
import java.io.InputStream;
import static org.jmock.AbstractExpectations.onConsecutiveCalls;
import static org.jmock.AbstractExpectations.returnValue;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.junit5.JUnit5Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class TestWebClientJMock {

  @RegisterExtension
  Mockery context =
      new JUnit5Mockery() {
        {
          setImposteriser(ClassImposteriser.INSTANCE); // para el mock de las clases
        }
      };

  @Test
  public void testGetContentOk() throws Exception {
    ConnectionFactory factory = context.mock(ConnectionFactory.class);
    InputStream mockStream = context.mock(InputStream.class);
    context.checking(
        new Expectations() {
          {
            oneOf(factory).getData();
            will(returnValue(mockStream));
            atLeast(1).of(mockStream).read();
            will(
                onConsecutiveCalls(
                    returnValue(Integer.valueOf((byte) 'W')),
                    returnValue(Integer.valueOf((byte) 'o')),
                    returnValue(Integer.valueOf((byte) 'r')),
                    returnValue(Integer.valueOf((byte) 'k')),
                    returnValue(Integer.valueOf((byte) 's')),
                    returnValue(Integer.valueOf((byte) '!')),
                    returnValue(-1)));
            oneOf(mockStream).close();
          }
        });
    WebClient client = new WebClient();
    String workingContent = client.getContent(factory);
    assertEquals("Works!", workingContent);
  }

  @Test
  public void testGetContentCannotCloseInputStream() throws Exception {
    ConnectionFactory factory = context.mock(ConnectionFactory.class);
    InputStream mockStream = context.mock(InputStream.class);
    context.checking(
        new Expectations() {
          {
            oneOf(factory).getData();
            will(returnValue(mockStream));
            oneOf(mockStream).read();
            will(returnValue(-1));
            oneOf(mockStream).close();
            will(throwException(new IOException("cannot close")));
          }
        });
    WebClient client = new WebClient();
    String workingContent = client.getContent(factory);
    assertNull(workingContent);
  }
}
