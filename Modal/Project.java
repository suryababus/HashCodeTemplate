package Modal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Project {
    public String projectName;
    public Integer projectDuration;
    public Integer scoreAwardedForProjectCompletion;
    public Integer bestBeforeDays;
    public Map<String , Integer> skillMap;
    public Integer totalWorkedDays = 0;
    public Integer endDay;
    public List<Contributor> contributors = new ArrayList<>();

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
    
     public Integer getEndDay() {
        return endDay;
    }

}
