package com.acceptance.interfaces;

public abstract class AbstractComponent {
    private String id;
    private Event event;

    public AbstractComponent(String id, Event event) {
        this.id = id;
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}

