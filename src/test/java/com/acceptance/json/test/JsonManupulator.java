package com.acceptance.json.test;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.acceptance.json.test.bean.ManupulatorBean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonManupulator
{

    ManupulatorBean manupulatorBean = ManupulatorBean.beanFactory();
    private static JsonManupulator jsonReader=null;
    private JsonManupulator()
    {
        jsonToMapMapping();
    }

    /*
    * This will return the singleton instance, not needed to create multiple object of this.
    */
    public static JsonManupulator getJsonReader()
    {
        if(jsonReader==null)
        {
            jsonReader = new JsonManupulator();
        }

      return jsonReader;
    }

    public JsonArray jsonReader()
    {
        JsonArray jsonArray = null;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("/home/gulve/acceptance_test/automation-test-with-json/src/test/java/com/acceptance/json/test/Login.json"));
            jsonArray = new Gson().fromJson(br,JsonArray.class);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
      return jsonArray;
    }

    public void jsonToMapMapping()
    {
       Gson gson = new Gson();
       JsonArray jo = jsonReader();
       if(jo==null)
       {
           return;
       }

       for (int j=0;j<jo.size();j++)
       {
           List<Map<String,String>>mapList= new ArrayList<Map<String, String>>();
           for (int i = 0; i < jo.get(j).getAsJsonArray().size(); i++)
           {
               Map<String, String> map;
               if(j==0 &&i==0)
               {
                   manupulatorBean.setUrl(jo.get(j).getAsJsonArray().get(i).getAsJsonObject().get("url").getAsString());
               }
               Type type = new TypeToken<Map<String, String>>() {}.getType();
               map = gson.fromJson(jo.get(j).getAsJsonArray().get(i), type);
               mapList.add(map);
           }
        manupulatorBean.addTestCase(mapList);
       }
    }

    public ManupulatorBean getManupulatorBean()
    {
        return this.manupulatorBean;
    }

}
