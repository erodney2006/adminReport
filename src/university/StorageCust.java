package university;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
//@Table
public class StorageCust {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long custid;
	private String location;
	private String lookerloc;
	private String amount;
	private String day;
	private String fname;
	private String lname;
	private String paidSofar;
	public long getCustid() {
		return custid;
	}
	public void setCustid(long custid) {
		this.custid = custid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLookerloc() {
		return lookerloc;
	}
	public void setLookerloc(String lookerloc) {
		this.lookerloc = lookerloc;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
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
	public String getPaidSofar() {
		return paidSofar;
	}
	public void setPaidSofar(String paidSofar) {
		this.paidSofar = paidSofar;
	}

	
	
}
