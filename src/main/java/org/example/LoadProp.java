package org.example;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProp
{
    static Properties prop;
    static FileInputStream input;

    public static String getProperty(String key) {
        prop = new Properties();
        try {
            input = new FileInputStream("src/test/java/TestConfig/TestData.properties");
            prop.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);

    }

    @Test
    public void readKeys() {
        System.out.println(getProperty("url"));
        System.out.println(getProperty("Fristname"));
    }

}
