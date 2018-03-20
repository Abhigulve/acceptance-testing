package com.acceptance.interfaces;

import com.codeborne.selenide.Selenide;

/**
 * @author Abhijeet Gulve
 */
public abstract class AbstractEvent implements Event {
    private String id;
    private String value;


    public AbstractEvent(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public Event open(String url) {
        Selenide.open(url);
        return this;
    }
}
