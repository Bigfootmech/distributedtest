package org.distributedtest.core.entities;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class EventsObject implements Serializable{
	
	private static final long serialVersionUID = 444146060280388441L;
	
	@NotNull
	@Valid
	private List<EventObject> events;

	public List<EventObject> getEvents() {
		return events;
	}

	public void setEvents(List<EventObject> events) {
		this.events = events;
	}

}
