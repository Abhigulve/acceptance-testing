package com.acceptance.entity;

import java.util.List;

public class AttributesList {

    List<Attributes> attributesList;

    public List<Attributes> getAttributesList() {
        return attributesList;
    }

    public void setAttributesList(List<Attributes> attributesList) {
        this.attributesList = attributesList;
    }

    public AttributesList(List<Attributes> attributesList) {

        this.attributesList = attributesList;
    }

    @Override
    public String toString() {
        return "AttributesList{" +
                "attributesList=" + attributesList +
                '}';
    }
}
