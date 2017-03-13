package org.distributedtest.filereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class SourceFileInput{
	private static final String SOURCE_FILE = "source.txt";

	public static void applyPerLine(Consumer<? super String> function) throws IOException, URISyntaxException{
		
		try (Stream<String> stream = asStringStream(getSourceFileInputStream())) {
			stream.forEach(function);
		}
	}

	private static InputStream getSourceFileInputStream() {
		return getClassLoader().getResourceAsStream(SOURCE_FILE);
	}

	private static Stream<String> asStringStream(InputStream inputStream) {
		return new BufferedReader(new InputStreamReader(inputStream)).lines();
	}

	private static ClassLoader getClassLoader() {
		return SourceFileInput.class.getClassLoader();
	}
}
