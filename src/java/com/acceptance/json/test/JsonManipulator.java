package com.acceptance.json.test;

import com.acceptance.json.test.bean.ManupulatorBean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonManipulator {

    private static JsonManipulator jsonReader = null;
    ManupulatorBean manupulatorBean = ManupulatorBean.beanFactory();
    private String fileName;

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
            List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
            for (int i = 0; i < jo.get(j).getAsJsonArray().size(); i++) {
                Map<String, String> map;
                if (j == 0 && i == 0) {
                    manupulatorBean.setUrl(jo.get(j).getAsJsonArray().get(i).getAsJsonObject().get("url").getAsString());
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

}
