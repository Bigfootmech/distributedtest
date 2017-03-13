package org.distributedtest.core.entities;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class EventObject implements Serializable{
	
	private static final long serialVersionUID = 444146060280388441L;
	
	@NotNull
	@Valid
	private AttributesObject attributes;

	public AttributesObject getAttributes() {
		return attributes;
	}

	public void setAttributes(AttributesObject attributes) {
		this.attributes = attributes;
	}
}
