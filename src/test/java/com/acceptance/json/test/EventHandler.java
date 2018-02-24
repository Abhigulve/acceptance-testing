package com.acceptance.json.test;

import com.acceptance.test.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import java.util.*;


public class EventHandler extends BaseTest
{
    static JsonManupulator jr;
    DomManupulation domManupulation;

    @BeforeEach
    public void setUp()
    {
         jr = JsonManupulator.getJsonReader();
         domManupulation = new DomManupulation();
    }

    @TestFactory
    public Collection<DynamicTest> sampleTest()
    {
        domManupulation.open(jr.getManupulatorBean().getUrl());
        List<List<Map<String,String>>>list=jr.getManupulatorBean().getList();
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        for(int j=0;j<list.size();j++)
        {
            domManupulation.open(jr.getManupulatorBean().getUrl());
            List<Map<String, String>> testCase = list.get(j);
            int i=0;
            for (Map<String, String> map : testCase)
            {
                domManupulation.action(map.get("id").toString(), map.get("value"), map.get("event").toUpperCase());
                i++;
                if(i==(testCase.size()))
                {
                    String testName = "Test"+map.get("testname") ;
                            DynamicTest dTest = DynamicTest.dynamicTest(testName,()-> domManupulation.testCaseAnalyser(map.get("id").toString(),map.get("condition").toUpperCase()));
                    dynamicTests.add(dTest);
                }
            }
        }
        return dynamicTests;
    }

}
