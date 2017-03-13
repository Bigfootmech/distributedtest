package org.distributedtest.consumer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import org.distributedtest.core.dao.tables.IEventsTable;
import org.distributedtest.core.entities.EventsObject;

@Controller
public class EventsController {
	
	@Autowired
	IEventsTable eventsTable;

    public static final String NAME_APIS = "/events";
	
	@RequestMapping(value=NAME_APIS, method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody EventsObject postSurname(@Valid @RequestBody EventsObject events) {
        
		eventsTable.insert(events);
		
        return events;
    }
}
