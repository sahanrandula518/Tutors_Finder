//Sahan Randula - developersstack
package Models;


public class System_users{

	private int system_user_id;
	private String name;
	private String username;
	private String password;
	private String user_type;
	private String email;

public System_users(){
}

public System_users(int system_user_id){
	this.system_user_id = system_user_id;
}
public System_users(int system_user_id,String name,String username,String password,String user_type,String email){
	this.system_user_id = system_user_id;
	this.name = name;
	this.username = username;
	this.password = password;
	this.user_type = user_type;
	this.email = email;
}

public int getSystem_user_id(){
return system_user_id;
}

public void setSystem_user_id(int system_user_id){
	this.system_user_id = system_user_id;
}

public String getName(){
return name;
}

public void setName(String name){
	this.name = name;
}

public String getUsername(){
return username;
}

public void setUsername(String username){
	this.username = username;
}

public String getPassword(){
return password;
}

public void setPassword(String password){
	this.password = password;
}

public String getUser_type(){
return user_type;
}

public void setUser_type(String user_type){
	this.user_type = user_type;
}

public String getEmail(){
return email;
}

public void setEmail(String email){
	this.email = email;
}

}