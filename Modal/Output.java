package Modal;

import java.util.List;

public class Output{
    public String fileName;

    public List<Project> projects;

    public Output(String fileName, List<Project> projects){
            this.fileName = fileName;
            this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public String getFileName() {
        return fileName;
    }
}
