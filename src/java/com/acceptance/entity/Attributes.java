package com.acceptance.entity;

import java.util.List;

public class Attributes {

    private List<Attribute> attributes;

    public Attributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Attribute> getAttributes() {

        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "attributes=" + attributes +
                '}';
    }
}
