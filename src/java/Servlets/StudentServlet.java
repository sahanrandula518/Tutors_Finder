//Sahan Randula - developersstack
package Servlets;


import Models.Student;
import Controllers.StudentController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})


public class StudentServlet extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

		String action = request.getParameter("action");
		String pattern = "yyyy/MM/dd - HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String current_date = simpleDateFormat.format(new Date());

		if (action.equals("insert")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String dob = request.getParameter("dob");
			int grade = Integer.parseInt(request.getParameter("grade"));
			Student obj = new Student();
			obj.setName(name);
			obj.setAddress(address);
			obj.setEmail(email);
			obj.setPhone(phone);
			obj.setDob(dob);
			obj.setGrade(grade);
			try {
				StudentController.getInstance().Save(obj);
				response.getWriter().println("Saved!");
			} catch (Exception ex) {
				//error
			}
		} else if (action.equals("update")) {
			int student_id = Integer.parseInt(request.getParameter("student_id"));
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String dob = request.getParameter("dob");
			int grade = Integer.parseInt(request.getParameter("grade"));
			Student obj = new Student();
			obj.setStudent_id(student_id);
			obj.setName(name);
			obj.setAddress(address);
			obj.setEmail(email);
			obj.setPhone(phone);
			obj.setDob(dob);
			obj.setGrade(grade);
			try {
				StudentController.getInstance().Update(obj);
				response.getWriter().println("Updated!");
			} catch (Exception ex) {
				//error
			}

		} else if (action.equals("delete")) {
			int student_id = Integer.parseInt(request.getParameter("student_id"));
			Student obj = new Student();
			obj.setStudent_id(student_id);
			try {
				StudentController.getInstance().Delete(obj);
				response.getWriter().println("Updated!");
			} catch (Exception ex) {
				//error
			}
		} else if (action.equals("serch")) {
			try {
				List<Student> list = new ArrayList<>();
				List stringList = new ArrayList<>();

				list = StudentController.getInstance().SearchAll();
				for (int i = 0; i < list.size(); i++) {
					String s = list.get(i).getStudent_id() + "_"+list.get(i).getName() + "_"+list.get(i).getAddress() + "_"+list.get(i).getEmail() + "_"+list.get(i).getPhone() + "_"+list.get(i).getDob() + "_"+list.get(i).getGrade() + "_";
					stringList.add(s);
				}
			String b = String.join("~", stringList);
			response.getWriter().println(b);
			} catch (Exception ex) {
				//Error
			}

		}
		}
	}

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		processRequest(request, response);
}

@Override
public String getServletInfo() {
	return "Short description";
}
}