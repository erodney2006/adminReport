package university;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
//@Table
public class StorageEmp {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long empyid;
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String email;
	public long getEmpyid() {
		return empyid;
	}
	public void setEmpyid(long empyid) {
		this.empyid = empyid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
