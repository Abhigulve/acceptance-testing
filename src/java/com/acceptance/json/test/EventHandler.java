package com.acceptance.json.test;

import com.acceptance.test.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class EventHandler extends BaseTest {
    static JsonManipulator jr;
    DomManipulation domManipulation;

    @BeforeEach
    public void setUp() {
        jr = JsonManipulator.getJsonReader("/home/gulve/acceptance_test/automation-test-with-json/src/java/com/acceptance/json/test/Login.json");
        domManipulation = new DomManipulation();
    }

    @TestFactory
    public Collection<DynamicTest> TestInitiator() {
        domManipulation.open(jr.getManupulatorBean().getUrl());
        String testName = jr.getManupulatorBean().getTestName();
        List<List<Map<String, String>>> list = jr.getManupulatorBean().getList();
        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for (int j = 0; j < list.size(); j++) {
            domManipulation.open(jr.getManupulatorBean().getUrl());
            List<Map<String, String>> testCase = list.get(j);
            int i = 0;

            for (int values = 1; values < testCase.size(); values++) {
                Map<String, String> map = testCase.get(values);
                domManipulation.action(map.get("id").toString(), map.get("value"), map.get("event").toUpperCase());
                i++;
                if (i == (testCase.size())) {
                    DynamicTest dTest = DynamicTest.dynamicTest(testName, ()->domManipulation.testCaseAnalyser(map.get("id").toString(), map.get("condition").toUpperCase()));
                    dynamicTests.add(dTest);
                }
            }
        }
        return dynamicTests;
    }

}
