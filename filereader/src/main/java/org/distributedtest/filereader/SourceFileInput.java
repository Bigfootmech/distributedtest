package org.distributedtest.filereader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class SourceFileInput{
	private static final String SOURCE_FILE = "source.txt";

	public static void applyPerLine(Consumer<? super String> function) throws IOException, URISyntaxException{
        
		try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(SOURCE_FILE).toURI()))) {
			stream.forEach(function);
		}
	}
}
