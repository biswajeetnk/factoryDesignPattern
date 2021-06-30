package org.factoryDesignPattern;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class BaseTest
{
    public WebDriver initialiseDrivers()
    {

        System.setProperty("webdriver.chrome.driver", "C://chromedriver_win32//chromedriver_ver90//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException
    {
        //objectMap.readValue() accepts String hence first we need to convert JSON file to String :
        String jsonFileContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8); //UTF_8 for String encoding

        //this class helps to map the JSON to HashMap, this class comes from jackson API
        ObjectMapper objectMap = new ObjectMapper();
        List<HashMap<String, String>> data = objectMap.readValue(jsonFileContent, new TypeReference<List<HashMap<String, String>>>() {}); //this accpets String, so first we need to convert the JSON to String
        //TypeReference class in Java helps to marshall and unmarshall, means it helps to convert JSON into HashMap

        return data;
    }
}
