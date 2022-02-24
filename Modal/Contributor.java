package Modal;

import java.util.HashMap;

public class Contributor {
	private String name; //Contributor name

	private int noOfSkills; // No of Skills Possessed by the Contributor

	private HashMap<String, Integer> skillMap; // Skill Vs Level

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
