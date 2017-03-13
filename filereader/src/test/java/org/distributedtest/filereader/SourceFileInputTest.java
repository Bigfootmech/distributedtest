package org.distributedtest.filereader;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

public class SourceFileInputTest {
	
	@Test
	public void structureTest_works() throws IOException, URISyntaxException{
		// given
		
		// when
		SourceFileInput.applyPerLine(System.out::println);
		
		// then
	}
}
