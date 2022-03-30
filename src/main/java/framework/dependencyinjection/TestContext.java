package framework.dependencyinjection;

import framework.controllers.FileReaderController;

public class TestContext {

    private FileReaderController fileReaderController;

    public TestContext()
    {
        fileReaderController = new FileReaderController();
    }

    public FileReaderController getFileReaderController() {

        return fileReaderController;
    }
    
}
