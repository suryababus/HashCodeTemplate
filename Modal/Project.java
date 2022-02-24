package Modal;

import java.util.Map;

public class Project {
    private String projectName;
    private Integer projectDuration;
    private Integer scoreAwardedForProjectCompletion;
    private Integer bestBeforeDays;
    private Map<String , Integer> skillMap;

    public Project(String projectName, Integer projectDuration, Integer scoreAwardedForProjectCompletion, Integer bestBeforeDays, Map<String, Integer> skillMap) {
        this.projectName = projectName;
        this.projectDuration = projectDuration;
        this.scoreAwardedForProjectCompletion = scoreAwardedForProjectCompletion;
        this.bestBeforeDays = bestBeforeDays;
        this.skillMap = skillMap;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getProjectDuration() {
        return projectDuration;
    }

    public void setProjectDuration(Integer projectDuration) {
        this.projectDuration = projectDuration;
    }

    public Integer getScoreAwardedForProjectCompletion() {
        return scoreAwardedForProjectCompletion;
    }

    public void setScoreAwardedForProjectCompletion(Integer scoreAwardedForProjectCompletion) {
        this.scoreAwardedForProjectCompletion = scoreAwardedForProjectCompletion;
    }

    public Integer getBestBeforeDays() {
        return bestBeforeDays;
    }

    public void setBestBeforeDays(Integer bestBeforeDays) {
        this.bestBeforeDays = bestBeforeDays;
    }

    public Map<String, Integer> getSkillMap() {
        return skillMap;
    }

    public void setSkillMap(Map<String, Integer> skillMap) {
        this.skillMap = skillMap;
    }

}
