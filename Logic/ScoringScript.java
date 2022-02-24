package Logic;

import Modal.Input;
import Modal.Output;
import Modal.Project;

import java.util.List;

public class ScoringScript {
    public Long calculateScore(Input input, Output output) {
        long totalSum = 0;
        List<Project> projects = output.projects;
        for (Project project : projects) {
            if (project.getEndDay() < project.getBestBeforeDays()) {
                totalSum += project.getScoreAwardedForProjectCompletion();
            } else {
                totalSum += Math.max((project.getEndDay() - project.getBestBeforeDays()), 0);
            }
        }
        return totalSum;
    }
}

