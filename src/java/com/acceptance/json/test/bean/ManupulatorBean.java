package com.acceptance.json.test.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManupulatorBean {
    static ManupulatorBean bean;
    List<List<Map<String, String>>> list;
    private String url;
    private String testName;

    public ManupulatorBean() {
        list = new ArrayList<>();
    }

    /**
    * No need to create multiple object so we are going with singleton
    */
    public static ManupulatorBean beanFactory() {
        if (bean == null) {
            bean = new ManupulatorBean();
        }
        return bean;
    }

    public List<List<Map<String, String>>> getList() {
        return list;
    }

    public void setList(List<List<Map<String, String>>> list) {
        this.list = list;
    }

    public void addTestCase(List<Map<String, String>> tstCase) {
        this.list.add(tstCase);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTestName() {

        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
}
