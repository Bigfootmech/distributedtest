package org.distributedtest.core.dao.tables;

import java.util.Optional;

import org.distributedtest.core.entities.EventsObject;

public interface IEventsTable {
	public Optional<Object> insert(EventsObject eventsObject);
}
