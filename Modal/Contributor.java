package Modal;

import java.util.HashMap;

public class Contributor {

    private String name;
    private int noOfSkills;
    private HashMap<String, Integer> skillMap;

    public Contributor(String name, int noOfSkills, HashMap<String, Integer> skillMap) {
        this.name = name;
        this.noOfSkills = noOfSkills;
        this.skillMap = skillMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfSkills() {
        return noOfSkills;
    }

    public void setNoOfSkills(int noOfSkills) {
        this.noOfSkills = noOfSkills;
    }

    public HashMap<String, Integer> getSkillMap() {
        return skillMap;
    }

    public void setSkillMap(HashMap<String, Integer> skillMap) {
        this.skillMap = skillMap;
    }
}
