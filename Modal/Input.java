package Modal;


import java.util.List;

public class Input {

    private String inputFileName;
    public List<Project> projects;
    public List<Contributor> contributors;

    public Input(String inputFileName) {
        this.inputFileName = inputFileName;
    }
    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }
}
