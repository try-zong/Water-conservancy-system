package Entity;

public class User {
	private String user ;
	private int jobNumber ;
	private String password ;
	private String role ;
	private String state ;
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public int getJobNumber() {
		return jobNumber;
	}
	
	public void setJobNumber(int jobNumber) {
		this.jobNumber = jobNumber;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public User(String user, int jobNumber, String password, String role, String state) {
		super();
		this.user = user;
		this.jobNumber = jobNumber;
		this.password = password;
		this.role = role;
		this.state = state;
	}
	
}
