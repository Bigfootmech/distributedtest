package org.distributedtest.producer.worker;

import java.io.IOException;
import java.net.URL;
import java.util.function.Consumer;

import org.apache.log4j.Logger;
import org.distributedtest.producer.net.NetClientPost;
import org.distributedtest.producer.resources.ResourceLoader;

public class HttpAsFunction<T extends String> implements Consumer<T>  {
	
	private final static Logger LOGGER = Logger.getLogger(HttpAsFunction.class);

	@Override
	public void accept(T t) {
		runForString(t);
	}
    
    private static void runForString(String postBody) {
		try {
			URL url = new URL(ResourceLoader.getInstance().getPostRequestDestination());
			new WorkerThread(url, postBody).run();
		} catch (IOException e) {
			LOGGER.error("Failed to run post body " + postBody, e);
		}
    }
	
}
