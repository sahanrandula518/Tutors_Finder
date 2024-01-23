//Sahan Randula - developersstack
package Models;


public class Subject{

	private int subject_id;
	private String name;
	private String category;
	private int grade;

public Subject(){
}

public Subject(int subject_id){
	this.subject_id = subject_id;
}
public Subject(int subject_id,String name,String category,int grade){
	this.subject_id = subject_id;
	this.name = name;
	this.category = category;
	this.grade = grade;
}

public int getSubject_id(){
return subject_id;
}

public void setSubject_id(int subject_id){
	this.subject_id = subject_id;
}

public String getName(){
return name;
}

public void setName(String name){
	this.name = name;
}

public String getCategory(){
return category;
}

public void setCategory(String category){
	this.category = category;
}

public int getGrade(){
return grade;
}

public void setGrade(int grade){
	this.grade = grade;
}

}