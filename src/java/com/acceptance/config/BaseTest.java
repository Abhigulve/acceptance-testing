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

        String driver = "";
        String os = System.getProperty("os.name");
        if(os.contains("Windows")){
            driver = "drivers/windows/chromedriver.exe";
        }else if(os.contains("Ubuntu")){
            driver = "drivers/ubuntu/chromedriver";
        }
        //switch to local drivers folder using File.exists
       // System.setProperty("webdriver.gecko.driver", "/Users/mmckenzie/development/branches/radix-dash-all/acceptance-tests/drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver", driver);
       // System.setProperty("webdriver.chrome.driver", "your/driver/path");
        //System.setProperty("webdriver.firefox.marionette", "/Users/mmckenzie/development/branches/radix-dash-all/acceptance-tests/drivers/geckodriver");
    }
}
