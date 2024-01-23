//Sahan Randula - developersstack
package Controllers;


import Models.Subject;
import Connector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class SubjectController{

	Connector con = Connector.getInstance();

	private SubjectController(){
	}

	private static final SubjectController obj = new SubjectController();

	public static SubjectController getInstance(){
		return obj;
	}

	public void Save(Subject data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO subject(name,category,grade) values ('" + data.getName()+ "','" + data.getCategory()+ "','" + data.getGrade()+ "') " );
	}

	public void Update(Subject data) throws Exception {
		con.getConnection();
		con.aud("UPDATE subject SET name  = '" + data.getName()+ "',category  = '" + data.getCategory()+ "',grade  = '" + data.getGrade()+ "' WHERE subject_id = '" + data.getSubject_id()+ "'");
	}

	public void Delete(Subject data) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM subject WHERE subject_id = '" + data.getSubject_id()+ "'");
	}

	public List<Subject> SearchAll() throws Exception {
		List<Subject> objList = new ArrayList<Subject>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM subject");
		while(rset.next()){
			Subject obj = new Subject();
			obj.setSubject_id(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setCategory(rset.getString(3));
			obj.setGrade(rset.getInt(4));
			objList.add(obj);
		}

	return objList;
	}

	public List<Subject> Search(Subject data) throws Exception {
		List<Subject> objList = new ArrayList<Subject>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM subject WHERE subject_id'" + data.getSubject_id()+ "'");
		while(rset.next()){
			Subject obj = new Subject();
			obj.setSubject_id(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setCategory(rset.getString(3));
			obj.setGrade(rset.getInt(4));
			objList.add(obj);
		}

	return objList;
	}

}