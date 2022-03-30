package runner;

import cucumber.api.cli.Main;

@SuppressWarnings("deprecation")
public class TestRunnerLocal {


    public static void main(String[] args) {

        Main.main(new String[]
        {
            "--glue",
            "stepdefinations",
            "src/test/resources/Features/PetStoreScenarios.feature"
        });
    }
    
}
