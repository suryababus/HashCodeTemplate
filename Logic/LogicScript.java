package Logic;

import Modal.Input;
import Modal.Output;

public class LogicScript {
    ScoringScript scoringScript = new ScoringScript();
    OutputScript outputScript = new OutputScript();
    void run(Input input){
        System.out.println("LogicScript - run ");
        Output output = new Output();
        // Hashcode: write the business logic

        scoringScript.calculateScore(input, output);
        outputScript.createOutputFile(output);
    }
}
