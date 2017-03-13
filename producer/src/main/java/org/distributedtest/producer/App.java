package org.distributedtest.producer;

import java.io.IOException;
import java.net.URISyntaxException;

import org.distributedtest.filereader.SourceFileInput;
import org.distributedtest.producer.worker.HttpAsFunction;

public class App 
{
    public static void main( String[] args ) throws IOException, URISyntaxException
    {
		SourceFileInput.applyPerLine(new HttpAsFunction<>());
		
        System.out.println( "Done!" );
    }
}
