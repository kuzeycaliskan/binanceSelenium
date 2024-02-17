package org.binance.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProjectProps {

    Properties props = null;

    public ProjectProps(){
        try{
            props = readPropertiesFile("inputs.properties");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Properties readPropertiesFile(String fileName) throws IOException {
        InputStream fis = null;
        Properties prop = null;

        try {
            fis = getClass().getClassLoader().getResourceAsStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch (FileNotFoundException fnfe){

        } catch (IOException ioe){
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }

    public String getPropertyValue(String propertyKey){
        return props.getProperty(propertyKey);
    }

}
