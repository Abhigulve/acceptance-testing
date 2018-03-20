package com.acceptance.config;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;

public abstract class BaseTest
{

    public BaseTest()
    {
        baseUrl = "https://github.com";
        browser = "chrome"; // chrome, ie, safari
        holdBrowserOpen = true;

        //switch to local drivers folder using File.exists
       // System.setProperty("webdriver.gecko.driver", "/Users/mmckenzie/development/branches/radix-dash-all/acceptance-tests/drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
       // System.setProperty("webdriver.chrome.driver", "your/driver/path");
        //System.setProperty("webdriver.firefox.marionette", "/Users/mmckenzie/development/branches/radix-dash-all/acceptance-tests/drivers/geckodriver");
    }
}
