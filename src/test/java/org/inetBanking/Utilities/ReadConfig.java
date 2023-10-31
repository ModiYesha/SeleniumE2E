package org.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties pro;
    public ReadConfig(){
        File src = new File("./Configuration/config.properties");
        try {
            FileInputStream fs = new FileInputStream(src);
            pro = new Properties();
            pro.load(fs);
        } catch (Exception e) {
            System.out.println("Exception is " +e.getMessage());
            //throw new RuntimeException(e);
        }
    }

    public String getApplicationURL(){
        String url = pro.getProperty("baseURL");
        return url;
    }

    public String getUsername(){
        String url = pro.getProperty("userName");
        return url;
    }

    public String getPassword(){
        String url = pro.getProperty("userPassword");
        return url;
    }
}

