//Sahan Randula - developersstack
package Controllers;


import Models.Student;
import Connector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class StudentController{

	Connector con = Connector.getInstance();

	private StudentController(){
	}

	private static final StudentController obj = new StudentController();

	public static StudentController getInstance(){
		return obj;
	}

	public void Save(Student data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO student(name,address,email,phone,dob,grade) values ('" + data.getName()+ "','" + data.getAddress()+ "','" + data.getEmail()+ "','" + data.getPhone()+ "','" + data.getDob()+ "','" + data.getGrade()+ "') " );
	}

	public void Update(Student data) throws Exception {
		con.getConnection();
		con.aud("UPDATE student SET name  = '" + data.getName()+ "',address  = '" + data.getAddress()+ "',email  = '" + data.getEmail()+ "',phone  = '" + data.getPhone()+ "',dob  = '" + data.getDob()+ "',grade  = '" + data.getGrade()+ "' WHERE student_id = '" + data.getStudent_id()+ "'");
	}

	public void Delete(Student data) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM student WHERE student_id = '" + data.getStudent_id()+ "'");
	}

	public List<Student> SearchAll() throws Exception {
		List<Student> objList = new ArrayList<Student>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM student");
		while(rset.next()){
			Student obj = new Student();
			obj.setStudent_id(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setAddress(rset.getString(3));
			obj.setEmail(rset.getString(4));
			obj.setPhone(rset.getString(5));
			obj.setDob(rset.getString(6));
			obj.setGrade(rset.getInt(7));
			objList.add(obj);
		}

	return objList;
	}

	public List<Student> Search(Student data) throws Exception {
		List<Student> objList = new ArrayList<Student>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM student WHERE student_id'" + data.getStudent_id()+ "'");
		while(rset.next()){
			Student obj = new Student();
			obj.setStudent_id(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setAddress(rset.getString(3));
			obj.setEmail(rset.getString(4));
			obj.setPhone(rset.getString(5));
			obj.setDob(rset.getString(6));
			obj.setGrade(rset.getInt(7));
			objList.add(obj);
		}

	return objList;
	}

}