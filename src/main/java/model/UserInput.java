package model;

public class UserInput {
	private String name;
	private String[] addr;
	private String gender;
	public String getName() {
		return name;
	}

	public String[] getAddr() {
		return addr;
	}
	public String getGender() {
		return gender;
	}
	
	public UserInput(String name, String[] addr, String gender) {
		this.name = name;
		this.addr = addr;
		this.gender = gender;
	}
}
