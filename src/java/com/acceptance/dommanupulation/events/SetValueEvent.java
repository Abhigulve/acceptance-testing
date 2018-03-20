package com.acceptance.dommanupulation.events;

import com.acceptance.interfaces.AbstractEvent;
import com.acceptance.interfaces.Event;

/**
 * @author Abhijeet Gulve
 */
public class SetValueEvent extends AbstractEvent {

    public SetValueEvent(String id, String value) {
        super(id, value);
    }

    @Override
    public Event action() {

        return null;
    }
}
