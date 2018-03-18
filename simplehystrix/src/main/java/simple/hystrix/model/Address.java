package simple.hystrix.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	private String line1;

	private String line2;

	public String getName() {
		return name;
	}

	public String getLine1() {
		return line1;
	}
	
	public Address withName(String name){
		this.name = name;
		return this;
	}

	public Address withLine1(String line1){
		this.line1 = line1;
		return this;
	}

	public Address withLine2(String line2){
		this.line2 = line2;
		return this;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public void setName(String name) {
		this.name = name;
	}

}