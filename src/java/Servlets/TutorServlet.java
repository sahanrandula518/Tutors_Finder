//Sahan Randula - developersstack
package Servlets;


import Models.Tutor;
import Controllers.TutorController;
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


@WebServlet(name = "TutorServlet", urlPatterns = {"/TutorServlet"})


public class TutorServlet extends HttpServlet {

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
			String subject = request.getParameter("subject");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String status = request.getParameter("status");
			Tutor obj = new Tutor();
			obj.setName(name);
			obj.setSubject(subject);
			obj.setEmail(email);
			obj.setPhone(phone);
			obj.setStatus(status);
			try {
				TutorController.getInstance().Save(obj);
				response.getWriter().println("Saved!");
			} catch (Exception ex) {
				//error
			}
		} else if (action.equals("update")) {
			int tutor_id = Integer.parseInt(request.getParameter("tutor_id"));
			String name = request.getParameter("name");
			String subject = request.getParameter("subject");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String status = request.getParameter("status");
			Tutor obj = new Tutor();
			obj.setTutor_id(tutor_id);
			obj.setName(name);
			obj.setSubject(subject);
			obj.setEmail(email);
			obj.setPhone(phone);
			obj.setStatus(status);
			try {
				TutorController.getInstance().Update(obj);
				response.getWriter().println("Updated!");
			} catch (Exception ex) {
				//error
			}

		} else if (action.equals("delete")) {
			int tutor_id = Integer.parseInt(request.getParameter("tutor_id"));
			Tutor obj = new Tutor();
			obj.setTutor_id(tutor_id);
			try {
				TutorController.getInstance().Delete(obj);
				response.getWriter().println("Updated!");
			} catch (Exception ex) {
				//error
			}
		} else if (action.equals("serch")) {
			try {
				List<Tutor> list = new ArrayList<>();
				List stringList = new ArrayList<>();

				list = TutorController.getInstance().SearchAll();
				for (int i = 0; i < list.size(); i++) {
					String s = list.get(i).getTutor_id() + "_"+list.get(i).getName() + "_"+list.get(i).getSubject() + "_"+list.get(i).getEmail() + "_"+list.get(i).getPhone() + "_"+list.get(i).getStatus() + "_";
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