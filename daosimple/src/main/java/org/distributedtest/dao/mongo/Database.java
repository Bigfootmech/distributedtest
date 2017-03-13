package org.distributedtest.dao.mongo;

import java.net.UnknownHostException;
import static java.util.Collections.singletonList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Repository
public class Database {
	
	private	MongoClient mongoClient;
	private DB db;
	
	public Database(@Value("${database.loc}") String loc, @Value("${database.username}") String username, 
			@Value("${database.password}") String password, @Value("${database.authdb}") String authdb, 
			@Value("${database.name}") String dbName) throws UnknownHostException {
		mongoClient = new MongoClient(singletonList(new ServerAddress(loc)), 
				singletonList(MongoCredential.createCredential(username, authdb, password.toCharArray())));
		db = mongoClient.getDB(dbName);
	}
	
	public DB getDb(){
		return db;
	}
	

}
