package com.acceptance.interfaces;

import com.acceptance.entity.Attributes;

/**
 * @author Abhijeet Gulve
 */
public abstract class AbstractEvent implements Event {
   private Attributes attributeList;

    public AbstractEvent(Attributes attributeList) {
        this.attributeList = attributeList;
    }
}
