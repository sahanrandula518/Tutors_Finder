//Sahan Randula - developersstack
package Controllers;


import Models.Tutor;
import Connector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TutorController{

	Connector con = Connector.getInstance();

	private TutorController(){
	}

	private static final TutorController obj = new TutorController();

	public static TutorController getInstance(){
		return obj;
	}

	public void Save(Tutor data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO tutor(name,subject,email,phone,status) values ('" + data.getName()+ "','" + data.getSubject()+ "','" + data.getEmail()+ "','" + data.getPhone()+ "','" + data.getStatus()+ "') " );
	}

	public void Update(Tutor data) throws Exception {
		con.getConnection();
		con.aud("UPDATE tutor SET name  = '" + data.getName()+ "',subject  = '" + data.getSubject()+ "',email  = '" + data.getEmail()+ "',phone  = '" + data.getPhone()+ "',status  = '" + data.getStatus()+ "' WHERE tutor_id = '" + data.getTutor_id()+ "'");
	}

	public void Delete(Tutor data) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM tutor WHERE tutor_id = '" + data.getTutor_id()+ "'");
	}

	public List<Tutor> SearchAll() throws Exception {
		List<Tutor> objList = new ArrayList<Tutor>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM tutor");
		while(rset.next()){
			Tutor obj = new Tutor();
			obj.setTutor_id(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setSubject(rset.getString(3));
			obj.setEmail(rset.getString(4));
			obj.setPhone(rset.getString(5));
			obj.setStatus(rset.getString(6));
			objList.add(obj);
		}

	return objList;
	}

	public List<Tutor> Search(Tutor data) throws Exception {
		List<Tutor> objList = new ArrayList<Tutor>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM tutor WHERE tutor_id'" + data.getTutor_id()+ "'");
		while(rset.next()){
			Tutor obj = new Tutor();
			obj.setTutor_id(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setSubject(rset.getString(3));
			obj.setEmail(rset.getString(4));
			obj.setPhone(rset.getString(5));
			obj.setStatus(rset.getString(6));
			objList.add(obj);
		}

	return objList;
	}

}