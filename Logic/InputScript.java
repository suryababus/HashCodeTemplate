package Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import Modal.Input;

public class  InputScript {

    String folderLocation = "InputFiles/";
    public void run() {
        System.out.println("InputScript - run ");
        runForAllFiles();
        // INFO: runFile("filename");
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
                sb.append(str);
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
        Input input = readLogic(inputString);
        input.inputFileName = filename;
        logicScript.run(input);
    }

    private Input readLogic(String inputString){
        Input input = new Input();
        // Hashcode: read inputs


        
        return input;
    }
}