package Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Modal.Contributor;
import Modal.Input;
import Modal.Project;

public class  InputScript {

    String folderLocation = "InputFiles/";
    public void run() {
        System.out.println("InputScript - run ");
        // runForAllFiles();
        // INFO: runFile("a_an_example.in");
        runFile("a_an_example.in.txt");
    }

    private void runFile(String fileName){
        String inputFilePath = folderLocation+fileName;
        File inputFile = new File(inputFilePath);
        try {
            InputStream inputSteam = new FileInputStream(inputFile);
            InputStreamReader isReader = new InputStreamReader(inputSteam);
            BufferedReader reader = new BufferedReader(isReader);
            StringBuffer sb = new StringBuffer();
            String str;
            while((str = reader.readLine())!= null){
                sb.append(str).append("\n");
            }
            readInputs(fileName.substring(0, fileName.length()-4), sb.toString());
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    private void runForAllFiles() {
        File directoryPath = new File(folderLocation);
        String contents[] = directoryPath.list();
        for(int i=0; i<contents.length; i++) {
            runFile(contents[i]);
        }
    }

    LogicScript logicScript = new LogicScript();
    public void readInputs(String filename, String inputString){
        Input input = readLogic(inputString, filename);
        HashMap<String, HashMap<Integer, List<Contributor>>> map = Input.getSkillVsContributorMap(input.contributors);
        logicScript.run(input);
    }

    private Input readLogic(String inputString, String filename){
        Input input = new Input(filename);
        List<Contributor> contributors = new ArrayList<>();
        List<Project> projects = new ArrayList<>();

        String inputStringSplit[] = inputString.split("###");
        String[] contributorValueArrayFull = inputStringSplit[1].split("\\r?\\n");
        int i = 0;
        while(i < contributorValueArrayFull.length){
            String[] contributorValueArray = contributorValueArrayFull[i].split(" ");
            if(contributorValueArray.length == 1) {
                i++;
                continue;
            }
            String name = contributorValueArray[0];
            Integer skillCount = Integer.parseInt(contributorValueArray[1]);
            Map<String, Integer> mp = new HashMap<>();
            i++;
            int j = i;
            while(i < j + skillCount){
                String[] skillValueArray = contributorValueArrayFull[i].split(" ");
                mp.put(skillValueArray[0], Integer.parseInt(skillValueArray[1]));
                i++;
            }
            contributors.add(new Contributor(name, skillCount, mp));
        }
        input.contributors = contributors;

        i = 0;
        String[] projectValueArrayFull = inputStringSplit[2].split("\\r?\\n");
        while(i < projectValueArrayFull.length){
            String[] projectValueArray = projectValueArrayFull[i].split(" ");
            if(projectValueArray.length == 1) {
                i++;
                continue;
            }
            String projectName = projectValueArray[0];
            Integer daysToCompleteProject = Integer.parseInt(projectValueArray[1]);
            Integer score = Integer.parseInt(projectValueArray[2]);
            Integer bestBefore = Integer.parseInt(projectValueArray[3]);
            Integer skillsCount = Integer.parseInt(projectValueArray[4]);
            i++;
            int j = i;
            Map<String, Integer> mp = new HashMap<>();
            while(i < j + skillsCount){
                String[] skillValueArray = projectValueArrayFull[i].split(" ");
                mp.put(skillValueArray[0], Integer.parseInt(skillValueArray[1]));
                i++;
            }
            projects.add(new Project(projectName,daysToCompleteProject,score, bestBefore, mp));
        }
        input.projects = projects;
        return input;
    }
}