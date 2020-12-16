package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropetiesReader {

    private static String projectdirectory = System.getProperty("user.dir");

    public static String ReadEnvironmentParameters(String key)
    {
        String value = null;
        try
        {
            Properties environmentparameters = new Properties();
            FileInputStream filepath = new FileInputStream
                    (new File(projectdirectory+"\\EnvironmentParameters.properties"));
            environmentparameters.load(filepath);
            value = environmentparameters.getProperty(key);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return value;

    }


}
