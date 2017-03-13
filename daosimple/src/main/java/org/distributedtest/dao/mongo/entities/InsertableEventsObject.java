package org.distributedtest.dao.mongo.entities;

import org.distributedtest.core.entities.AttributesObject;
import org.distributedtest.core.entities.EventObject;
import org.distributedtest.core.entities.EventsObject;
import static org.distributedtest.core.constants.EventsConstants.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mongodb.BasicDBObject;

public class InsertableEventsObject extends BasicDBObject{ // This could be done better
	
	private static final long serialVersionUID = -174129393767778732L;
	
	public static List<InsertableEventsObject> from(EventsObject eventsObject){
		
		List<InsertableEventsObject> list = new ArrayList<>();
		
		Iterator<EventObject> iter = eventsObject.getEvents().iterator();
		while(iter.hasNext()){
			AttributesObject attributes = iter.next().getAttributes();
			list.add(insertableObjectFromAttributes(attributes));
		}
		
		return list;
	}

	private static InsertableEventsObject insertableObjectFromAttributes(AttributesObject attributes) {
		InsertableEventsObject createObject = new InsertableEventsObject();
		createObject.setAccountNumber(attributes.getAccountNumber());
		createObject.setTransactionAmount(attributes.getTransactionAmount());
		createObject.setName(attributes.getName());
		createObject.setProduct(attributes.getProduct());
		return createObject;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.put(ACCOUNT_NUMBER, accountNumber);
	}
	public void setTransactionAmount(String transactionAmount) {
		this.put(TRANSACTION_AMOUNT, transactionAmount);
	}
	public void setName(String name) {
		this.put(NAME, name);
	}
	public void setProduct(String product) {
		this.put(PRODUCT, product);
	}
	
	
}
