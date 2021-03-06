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

        for( int i =0;i< onGoingProjects.size();i++){
            Project p = onGoingProjects.get(i);
            p.totalWorkedDays =  p.totalWorkedDays+1;
            if(p.totalWorkedDays==p.projectDuration-1){
                for(int j=0;j< p.contributors.size();j++){
                    Contributor c = p.contributors.get(j);
                    // allContributors.get(p.skills.get(j)).putIfAbsent(, value)
                    takenContributor.put(c.getName(), false);
                }
                completedProjects.add(p);
                onGoingProjects.remove(i);
            }
        }



    }

    void runProjectAssignSchedular(){
        
        // for each waiting project
        // check if skills available and move from awaitingProjects to ongoingProjects


        
        for(int i=0;i< awaitingProjects.size();i++){
            Project p = awaitingProjects.get(i);
            var assignedContributors = new ArrayList<Contributor>();
            var skillList = new ArrayList<String>();
            boolean skillnotavailable = false;
            for(Entry<String, Integer> requiredSkill : p.skillMap.entrySet()){

                Boolean assigned = false;
                var levels = allContributors.get(requiredSkill.getKey()).entrySet();
                for(Entry<Integer, List<Contributor>> skilLevel : levels){
                    Integer _requiredSkill = requiredSkill.getValue();
                    Integer _skilLevel = skilLevel.getKey();
                    if(_skilLevel >= _requiredSkill){
                        List<Contributor> vc = skilLevel.getValue();
                        for(Contributor c: vc){
                            if(takenContributor.get(c.getName())==null || !takenContributor.get(c.getName())){
                                assignedContributors.add(c);
                                skillList.add(requiredSkill.getKey());
                                assigned =true;
                                break;
                            }
                        }
                        if(assigned){
                            break;
                        }
                    }
                }   

                if(!assigned){
                    skillnotavailable = true;
                    break;
                }
            }
            if(skillnotavailable){
                continue;
            }else{
                p.contributors = assignedContributors;
                p.skills = skillList;
                for(Contributor c: assignedContributors){
                    takenContributor.put(c.getName(), true);
                }
                awaitingProjects.remove(i);
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
        Integer totalDaysToRun = 10000;
        
        for(int i=0;(i<totalDaysToRun && (awaitingProjects.size()>0 || onGoingProjects.size()>0));i++){
            runProjectAssignSchedular();
            runProjectSchedular();
        }
        
        
        
        Output output = new Output(input.getInputFileName(), completedProjects);

        scoringScript.calculateScore(input, output);
        outputScript.createOutputFile(output);
    }
}
