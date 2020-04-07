package com.sebastian.testing.mock;

import java.io.InputStream;

public interface ConnectionFactory {
  InputStream getData() throws Exception;
}
