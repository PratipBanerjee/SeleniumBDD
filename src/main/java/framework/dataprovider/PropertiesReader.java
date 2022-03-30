package framework.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private String environmentParametersFile =
            System.getProperty("user.dir")+"\\src\\main\\resources\\config\\EnvironmentParameters.properties";

    private Properties environmentparameters;

    public PropertiesReader() {

        environmentparameters = new Properties();

        try
        {
            FileInputStream filepath = new FileInputStream
                    (new File(environmentParametersFile));
            environmentparameters.load(filepath);
            filepath.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    public String getBaseURL() {

        String BaseURL = environmentparameters.getProperty("BaseURL");
        return BaseURL;
    }

}
