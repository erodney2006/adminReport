package university;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table
public class Store3 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long storeid;
	private String outsideLockers;
	private String insideFloor1;
	private String insideFloor2;
	private String insideFloor3;
	private String description;
	public long getStoreid() {
		return storeid;
	}
	public void setStoreid(long storeid) {
		this.storeid = storeid;
	}
	public String getOutsideLockers() {
		return outsideLockers;
	}
	public void setOutsideLockers(String outsideLockers) {
		this.outsideLockers = outsideLockers;
	}
	public String getInsideFloor1() {
		return insideFloor1;
	}
	public void setInsideFloor1(String insideFloor1) {
		this.insideFloor1 = insideFloor1;
	}
	public String getInsideFloor2() {
		return insideFloor2;
	}
	public void setInsideFloor2(String insideFloor2) {
		this.insideFloor2 = insideFloor2;
	}
	public String getInsideFloor3() {
		return insideFloor3;
	}
	public void setInsideFloor3(String insideFloor3) {
		this.insideFloor3 = insideFloor3;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
