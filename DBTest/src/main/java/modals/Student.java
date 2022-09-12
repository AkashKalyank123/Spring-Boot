package modals;

import java.sql.Date;
public class Student {

	private int rollno;
	private String firstname;
	private String lastname;
	private int age;
	private String city;
	private Date joningDate;
	
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getJoingDate() {
		return joningDate;
	}
	public void setJoningDate(Date joningDate) {
		this.joningDate = joningDate;
	}
	
	
	
}
