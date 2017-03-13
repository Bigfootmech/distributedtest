package org.distributedtest.dao.mongo;

import static org.junit.Assert.*;

import java.net.UnknownHostException;

import org.distributedtest.dao.App;
import org.distributedtest.dao.mongo.entities.InsertableEventsObject;
import org.distributedtest.dao.mongo.tables.EventsTable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.WriteResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class})
@TestPropertySource(locations="classpath:test.properties")
public class MongoIntegrationTest {
	
	@Autowired
	private EventsTable events;
	
	@Test
	public void testDefaultApiWorks() throws Exception{
		// given
		InsertableEventsObject event = new InsertableEventsObject();
		event.setAccountNumber("12");
		event.setName("Peter Raddish");
		event.setProduct("Limping Athletes");
		event.setTransactionAmount("JPY 1.00");

		// when
        WriteResult result = events.insert(event);
        
        
		// then
        assertTrue(result.wasAcknowledged());
        //assertNull(result.getError());

	}
}
