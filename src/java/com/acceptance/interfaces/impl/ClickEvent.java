package com.acceptance.interfaces.impl;

import com.acceptance.entity.Attributes;
import com.acceptance.interfaces.AbstractEvent;
import com.acceptance.interfaces.Event;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ClickEvent extends AbstractEvent {


    public ClickEvent(Attributes attributeList) {
        super(attributeList);
    }

    @Override
    public Event performAction(String id) {
        $(By.id(id)).click();
        return this;
    }
}
