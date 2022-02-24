package Logic;

import java.util.ArrayList;

import Modal.Input;
import Modal.Output;
import Modal.Project;

public class LogicScript {
    ScoringScript scoringScript = new ScoringScript();
    OutputScript outputScript = new OutputScript();
    Input input;
    ArrayList<Project> awaitingProjects = new ArrayList<Project>();
    ArrayList<Project> onGoingProjects = new ArrayList<Project>();
    ArrayList<Project> completedProjects = new ArrayList<Project>();


    void runProjectSchedular(){
        // for each ongoing project increment running days.
        // check project done and move to completed Projects
        // increment skills for each contributor in the project and move contributors to available
    }

    void runProjectAssignSchedular(){
        // for each waiting project
        // check if skills available and move from awaitingProjects to ongoingProjects
    }


    void run(Input input){
        System.out.println("LogicScript - run ");

        this.input = input;
        Output output = new Output();
        // Hashcode: write the business logic

        scoringScript.calculateScore(input, output);
        outputScript.createOutputFile(output);
    }
}
