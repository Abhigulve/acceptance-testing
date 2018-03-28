package com.acceptance.entity;

public class Attribute {

    private String key;
    private String value;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {

        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Attribute(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
