package Modal;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Input {

    private String inputFileName;
    public List<Project> projects;
    public List<Contributor> contributors;

    public HashMap<String, HashMap<Integer, List<Contributor>>> skillVsContributorMap;

    public Input(String inputFileName) {
        this.inputFileName = inputFileName;
    }
    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public static HashMap<String, HashMap<Integer, List<Contributor>>> getSkillVsContributorMap(List<Contributor> contributors)
    {
        HashMap<String, HashMap<Integer, List<Contributor>>> skillVsContributorsMap= new HashMap<>();

        for(Contributor contributor : contributors)
        {
            for(String skill : contributor.getSkillMap().keySet())
            {
                skillVsContributorsMap.putIfAbsent(skill, new HashMap<Integer, List<Contributor>>());

                int level = contributor.getSkillMap().get(skill);

                HashMap<Integer, List<Contributor>> levelVsContributorMap = skillVsContributorsMap.get(skill);

                levelVsContributorMap.putIfAbsent(level, new ArrayList<Contributor>());

                List<Contributor> contributors_list_in_map = skillVsContributorsMap.get(skill).get(level);

                contributors_list_in_map.add(contributor);

                levelVsContributorMap.put(level, contributors_list_in_map);

                skillVsContributorsMap.put(skill,levelVsContributorMap);
            }
        }

        return skillVsContributorsMap;
    }
}
