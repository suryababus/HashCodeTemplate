package Logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import Modal.Contributor;
import Modal.Input;
import Modal.Output;
import Modal.Project;

public class LogicScript {
    ScoringScript scoringScript = new ScoringScript();
    OutputScript outputScript = new OutputScript();
    Input input;
    HashMap<String, Boolean> takenContributor = new  HashMap<String, Boolean>();
    HashMap<String, HashMap<Integer, List<Contributor>>> allContributors;
    List<Project> awaitingProjects = new ArrayList<Project>();
    List<Project> onGoingProjects = new ArrayList<Project>();
    List<Project> completedProjects = new ArrayList<Project>();


    void runProjectSchedular(){
        // for each ongoing project increment worked days.
        // check project done (worked days === projectDuration) and move to completed Projects
        // increment skills for each contributor in the project and move contributors to available

        for( Project p: onGoingProjects){
            p.totalWorkedDays++;
            if(p.totalWorkedDays==p.projectDuration-1){
                onGoingProjects.remove(p);
                completedProjects.add(p);
                for(Contributor c: p.contributors){
                    // allContributors.get(c.)
                    // need to increment skills for contributors
                }
            }
        }



    }

    void runProjectAssignSchedular(){
        
        // for each waiting project
        // check if skills available and move from awaitingProjects to ongoingProjects


        
        for(Project p: awaitingProjects){
            var assignedContributors = new ArrayList<Contributor>();
            boolean skillnotavailable = false;
            for(Entry<String, Integer> requiredSkill : p.skillMap.entrySet()){

                Boolean assigned = false;
                for(Entry<Integer, List<Contributor>> skilLevel : allContributors.get(requiredSkill.getKey()).entrySet()){
                    Integer _requiredSkill = requiredSkill.getValue();
                    Integer _skilLevel = skilLevel.getKey();
                    if(_skilLevel >= _requiredSkill){
                        List<Contributor> vc = skilLevel.getValue();
                        for(Contributor c: vc){
                            if(!takenContributor.get(c.getName())){
                                assignedContributors.add(c);
                                assigned =true;
                                break;
                            }
                        }
                    }
                }   

                if(!assigned){
                    skillnotavailable = true;
                    break;
                }
            }
            if(skillnotavailable){
                break;
            }else{
                p.contributors = assignedContributors;
                for(Contributor c: assignedContributors){
                    takenContributor.put(c.getName(), true);
                }
                awaitingProjects.remove(p);
                onGoingProjects.add(p);
            }
        }

    }


    void run(Input input){
        System.out.println("LogicScript - run ");

        this.input = input;
        // Hashcode: write the business logic
        awaitingProjects = input.projects;
        allContributors = Input.getSkillVsContributorMap(input.contributors);
        Integer totalDaysToRun = 1000;
        
        for(int i=0;(i<totalDaysToRun && (awaitingProjects.size()>0 || onGoingProjects.size()>0));i++){
            runProjectAssignSchedular();
            runProjectSchedular();
        }
        
        
        
        Output output = new Output(input.getInputFileName(), completedProjects);

        scoringScript.calculateScore(input, output);
        outputScript.createOutputFile(output);
    }
}
