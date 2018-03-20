package com.acceptance.json.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DomManupulation
{

    public DomManupulation open(String url)
    {
        Selenide.open(url);
        return this;
    }

    public DomManupulation action(String id, String value, String events)
    {
        switch (events)
        {
            case "CLICK":
                $(By.id(id)).click();
                return this;

            case "SETVALUE":
                $(By.id(id)).setValue(value);
                return this;

            default:
                return this;
        }
    }

    public SelenideElement testCaseAnalyser(String id, String visible)
    {
        switch (visible)
        {
            case "VISIBLE":
                return $(By.id(id)).shouldHave(Condition.visible);

            case "NOTVISIBLE":
                return $(By.id(id)).shouldNot(Condition.visible);
            default:
                assert false;
        }
        return null;
    }

}
