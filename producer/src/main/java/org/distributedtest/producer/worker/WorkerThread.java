package org.distributedtest.producer.worker;

import java.net.URL;

import org.distributedtest.producer.net.NetClientPost;

public class WorkerThread implements Runnable {

	private URL destinationUrl;
	private String postBody;
	
	public WorkerThread(URL destinationUrl, String postBody){
		this.destinationUrl = destinationUrl;
		this.postBody = postBody;
	}

	@Override
	public void run() {
		NetClientPost.postString(destinationUrl, postBody);
	}
}
