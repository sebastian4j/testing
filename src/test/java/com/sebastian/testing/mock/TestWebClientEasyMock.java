package com.sebastian.testing.mock;

import java.io.IOException;
import java.io.InputStream;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestWebClientEasyMock {

	private ConnectionFactory factory;
	private InputStream stream;

	@BeforeEach
	public void setUp() {
		factory = createMock("factory", ConnectionFactory.class);
		stream = createMock("stream", InputStream.class);
	}

	@Test
	public void testGetContentOk() throws Exception {
		expect(factory.getData()).andReturn(stream);
		expect(stream.read()).andReturn(Integer.valueOf((byte) 'W'));
		expect(stream.read()).andReturn(Integer.valueOf((byte) 'o'));
		expect(stream.read()).andReturn(Integer.valueOf((byte) 'r'));
		expect(stream.read()).andReturn(Integer.valueOf((byte) 'k'));
		expect(stream.read()).andReturn(Integer.valueOf((byte) 's'));
		expect(stream.read()).andReturn(Integer.valueOf((byte) '!'));
		expect(stream.read()).andReturn(-1);
		stream.close();
		replay(factory);
		replay(stream);
		WebClient client = new WebClient();
		assertEquals("Works!", client.getContent(factory));
	}

	@Test
	public void testGetContentCannotCloseInputStream() throws Exception {
		expect(factory.getData()).andReturn(stream);
		expect(stream.read()).andReturn(-1);
		stream.close();
		expectLastCall().andThrow(new IOException("cannot close"));
		replay(factory);
		replay(stream);
		WebClient client = new WebClient();
		String workingContent = client.getContent(factory);
		assertNull(workingContent );
	}
	

	@AfterEach
	public void tearDown() {
		verify(factory);
		verify(stream);
	}
}
