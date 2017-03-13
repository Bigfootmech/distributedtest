package org.distributedtest.dao.mongo.tables;

import java.util.Optional;

import org.distributedtest.core.dao.tables.IEventsTable;
import org.distributedtest.core.entities.EventsObject;
import org.distributedtest.dao.mongo.Database;
import org.distributedtest.dao.mongo.entities.InsertableEventsObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.WriteResult;

@Repository
public class EventsTable implements IEventsTable{

	private DBCollection table;
	
	public EventsTable(@Autowired Database database, @Value("${table.name}") String tableName){
		table = database.getDb().getCollection(tableName);
	}
	
	public WriteResult insert(BasicDBObject object){
		return table.insert(object);
	}

	@Override
	public Optional<Object> insert(EventsObject eventsObject) {
		return Optional.of(
				table.insert(InsertableEventsObject.from(eventsObject))
				);
	}

}
