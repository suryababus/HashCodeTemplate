package Logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Modal.Contributor;
import Modal.Output;
import Modal.Project;

public class OutputScript {
    public void createOutputFile(Output output){
        System.out.println("OutputScript - run ");
        String outputFormatedString = formatOutput(output);
        createAndWriteToFile(output.fileName, outputFormatedString);
    }
    private void createAndWriteToFile(String fileName, String fileContent){
        String location = "OutputFiles/"+fileName+".txt";
        File outputFile = new File(location);
        FileWriter fileWriter;
        try {
            outputFile.createNewFile();
            fileWriter = new FileWriter(outputFile);
            fileWriter.write(fileContent);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatOutput(Output output){
        StringBuilder result = new StringBuilder();
        // Hashcode: logic for output formating
        result.append(output.getProjects().size());
        result.append("\n");
        for(Project project : output.projects)
        {
            result.append(project.projectName);
            result.append("\n");
            for(Contributor contributor : project.contributors)
            {
                result.append(contributor.getName());
                result.append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

}
