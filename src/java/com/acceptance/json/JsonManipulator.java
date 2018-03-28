package com.acceptance.json;

import com.acceptance.entity.Attribute;
import com.acceptance.entity.Attributes;
import com.acceptance.entity.AttributesList;
import com.acceptance.json.bean.ManupulatorBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonManipulator {

    private static JsonManipulator jsonReader;
    ManupulatorBean manupulatorBean = ManupulatorBean.beanFactory();

    private JsonManipulator(String fileName) {
        jsonToMapMapping(fileName);
    }

    /**
     * This will return the singleton instance, not needed to create multiple object of this.
     */
    public static JsonManipulator getJsonReader(String fileName) {
        if (jsonReader == null) {
            jsonReader = new JsonManipulator(fileName);
        }
        return jsonReader;
    }

    public JsonArray jsonReader(String fileName) {
        JsonArray jsonArray = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            jsonArray = new Gson().fromJson(br, JsonArray.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    public void jsonToMapMapping(String fileName) {
        Gson gson = new Gson();
        JsonArray jo = jsonReader(fileName);
        if (jo == null) {
            return;
        }

        for (int j = 0; j < jo.size(); j++) {
            List<Map<String, String>> mapList = new ArrayList<>();
            for (int i = 0; i < jo.get(j).getAsJsonArray().size(); i++) {
                Map<String, String> map;
                if (j == 0 && i == 0) {
                    manupulatorBean.setUrl(jo.get(j).getAsJsonArray().get(i).getAsJsonObject().get("url").getAsString());
                    manupulatorBean.setTestName(jo.get(j).getAsJsonArray().get(i).getAsJsonObject().get("testname").getAsString());

                }
                Type type = new TypeToken<Map<String, String>>() {
                }.getType();
                map = gson.fromJson(jo.get(j).getAsJsonArray().get(i), type);
                mapList.add(map);
            }
            manupulatorBean.addTestCase(mapList);
        }
    }

    public ManupulatorBean getManupulatorBean() {
        return this.manupulatorBean;
    }


    public void getComponentActionJson(String fileName){
        //JsonArray jo = jsonReader(fileName);

        String str = stringReader(fileName);
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        try {
            AttributesList attributesList =  mapper.readValue(str.toString(), AttributesList.class);
            System.out.println(attributesList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
       // JsonManipulator manipulator = new JsonManipulator("resources/Login.json");
       // manipulator.getComponentActionJson("resources/Login.json");

        ObjectMapper om = new ObjectMapper();

        Attribute attr = new Attribute("Id","a");
        Attribute attr1 = new Attribute("value","a");
        Attribute attr2 = new Attribute("event","a");

        List list = new ArrayList();
        list.add(attr);
        list.add(attr1);
        list.add(attr2);
        Attributes attributes = new Attributes(list);

       List list1 =  new ArrayList<Attributes>();
        list1.add(attributes);
        AttributesList attributesList = new AttributesList(list1);

        try {
            String json = om.writeValueAsString(attributesList);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private String stringReader(String filePath){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            stringBuilder.append(br.readLine());
            while (br.readLine() != null){
                stringBuilder.append(br.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
