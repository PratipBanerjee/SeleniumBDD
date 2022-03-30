package framework.controllers;

import framework.dataprovider.PropertiesReader;

public class FileReaderController {

    private static FileReaderController inputFileController = new FileReaderController();

    private static PropertiesReader propertiesReader;

    public static FileReaderController getInstance() {

        return inputFileController;
    }

    public PropertiesReader getPropertiesReader() {

        if(propertiesReader == null)
        propertiesReader = new PropertiesReader();
        return propertiesReader;
    }
    
}
