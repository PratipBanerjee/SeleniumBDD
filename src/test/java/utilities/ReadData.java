package utilities;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class ReadData {

    static String projectdirectory = System.getProperty("user.dir");

    public static String ReadEnvironmentParameters(String key) throws IOException
    {
        Properties setupenvironment = new Properties();
        FileInputStream filepath = new FileInputStream(new File(projectdirectory+"\\Environment.properties"));
        setupenvironment.load(filepath);
        String value = setupenvironment.getProperty(key);
        return value;

    }


    public static String ReadObjectRepository(String key) throws IOException
    {
        Properties objectrepository = new Properties();
        FileInputStream filepath = new FileInputStream(new File(projectdirectory+"\\ObjectRepository.properties"));
        objectrepository.load(filepath);
        String value = objectrepository.getProperty(key);
        return value;
    }



    public static String GetTestData(String testcasetorun, String columnname) throws FilloException
    {
        String testdatavalue = null;
        Fillo TestData = new Fillo();
        Connection gettestdata = TestData.getConnection(projectdirectory+"\\TestData.xlsx");
        String testdataquery = "Select * from TestData where Testcase = '"+testcasetorun+"'";
        Recordset teststepdata = gettestdata.executeQuery(testdataquery);
        teststepdata.next();
        ArrayList<String> TestDataList = teststepdata.getFieldNames();
        Iterator<String> TestDataIterator = TestDataList.iterator();
        while(TestDataIterator.hasNext())
        {
            for(int i = 0; i<TestDataList.size()-1; i++)
            {
                String data = TestDataIterator.next();
                String datavalue = teststepdata.getField(data);
                if(data.equalsIgnoreCase(columnname))
                {
                    i=i+0;
                    String testData=TestDataList.get(i);
                    String testValue= teststepdata.getField(testData);
                    testdatavalue = testValue;
                    break;

                }

            }

            break;

        }

        return testdatavalue;
    }

}
