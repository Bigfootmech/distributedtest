package org.distributedtest.producer.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.log4j.Logger;

public class NetClientPost {
	
	private final static Logger LOGGER = Logger.getLogger(NetClientPost.class);
	
	private NetClientPost(){
		// Util class
	}
	
	public static void postString(URL destinationUrl, String postBody) {

	    try {

			HttpURLConnection conn = (HttpURLConnection) destinationUrl.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
	
			OutputStream os = conn.getOutputStream();
			os.write(postBody.getBytes());
			os.flush();
	
			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				LOGGER.error("Failed : HTTP error code : "+ conn.getResponseCode());
			}
	
			LOGGER.debug(conn.getResponseMessage());
	
			conn.disconnect();
	
	    } catch (IOException e) {
			LOGGER.error(e);
	    }
	}

}