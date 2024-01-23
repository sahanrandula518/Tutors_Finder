//Sahan Randula - developersstack
package Controllers;


import Models.System_users;
import Connector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class System_usersController{

	Connector con = Connector.getInstance();

	private System_usersController(){
	}

	private static final System_usersController obj = new System_usersController();

	public static System_usersController getInstance(){
		return obj;
	}

	public void Save(System_users data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO system_users(name,username,password,user_type,email) values ('" + data.getName()+ "','" + data.getUsername()+ "','" + data.getPassword()+ "','" + data.getUser_type()+ "','" + data.getEmail()+ "') " );
	}

	public void Update(System_users data) throws Exception {
		con.getConnection();
		con.aud("UPDATE system_users SET name  = '" + data.getName()+ "',username  = '" + data.getUsername()+ "',password  = '" + data.getPassword()+ "',user_type  = '" + data.getUser_type()+ "',email  = '" + data.getEmail()+ "' WHERE system_user_id = '" + data.getSystem_user_id()+ "'");
	}

	public void Delete(System_users data) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM system_users WHERE system_user_id = '" + data.getSystem_user_id()+ "'");
	}

	public List<System_users> SearchAll() throws Exception {
		List<System_users> objList = new ArrayList<System_users>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM system_users");
		while(rset.next()){
			System_users obj = new System_users();
			obj.setSystem_user_id(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setUsername(rset.getString(3));
			obj.setPassword(rset.getString(4));
			obj.setUser_type(rset.getString(5));
			obj.setEmail(rset.getString(6));
			objList.add(obj);
		}

	return objList;
	}

	public List<System_users> Search(System_users data) throws Exception {
		List<System_users> objList = new ArrayList<System_users>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM system_users WHERE system_user_id'" + data.getSystem_user_id()+ "'");
		while(rset.next()){
			System_users obj = new System_users();
			obj.setSystem_user_id(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setUsername(rset.getString(3));
			obj.setPassword(rset.getString(4));
			obj.setUser_type(rset.getString(5));
			obj.setEmail(rset.getString(6));
			objList.add(obj);
		}

	return objList;
	}

}