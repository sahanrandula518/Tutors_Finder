//Sahan Randula - developersstack
package Models;


public class Tutor{

	private int tutor_id;
	private String name;
	private String subject;
	private String email;
	private String phone;
	private String status;

public Tutor(){
}

public Tutor(int tutor_id){
	this.tutor_id = tutor_id;
}
public Tutor(int tutor_id,String name,String subject,String email,String phone,String status){
	this.tutor_id = tutor_id;
	this.name = name;
	this.subject = subject;
	this.email = email;
	this.phone = phone;
	this.status = status;
}

public int getTutor_id(){
return tutor_id;
}

public void setTutor_id(int tutor_id){
	this.tutor_id = tutor_id;
}

public String getName(){
return name;
}

public void setName(String name){
	this.name = name;
}

public String getSubject(){
return subject;
}

public void setSubject(String subject){
	this.subject = subject;
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

public String getStatus(){
return status;
}

public void setStatus(String status){
	this.status = status;
}

}