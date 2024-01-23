//Sahan Randula - developersstack
package Models;


public class Student{

	private int student_id;
	private String name;
	private String address;
	private String email;
	private String phone;
	private String dob;
	private int grade;

public Student(){
}

public Student(int student_id){
	this.student_id = student_id;
}
public Student(int student_id,String name,String address,String email,String phone,String dob,int grade){
	this.student_id = student_id;
	this.name = name;
	this.address = address;
	this.email = email;
	this.phone = phone;
	this.dob = dob;
	this.grade = grade;
}

public int getStudent_id(){
return student_id;
}

public void setStudent_id(int student_id){
	this.student_id = student_id;
}

public String getName(){
return name;
}

public void setName(String name){
	this.name = name;
}

public String getAddress(){
return address;
}

public void setAddress(String address){
	this.address = address;
}

public String getEmail(){
return email;
}

public void setEmail(String email){
	this.email = email;
}

public String getPhone(){
return phone;
}

public void setPhone(String phone){
	this.phone = phone;
}

public String getDob(){
return dob;
}

public void setDob(String dob){
	this.dob = dob;
}

public int getGrade(){
return grade;
}

public void setGrade(int grade){
	this.grade = grade;
}

}