//Sahan Randula - developersstack
package Servlets;


import Models.Subject;
import Controllers.SubjectController;
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


@WebServlet(name = "SubjectServlet", urlPatterns = {"/SubjectServlet"})


public class SubjectServlet extends HttpServlet {

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
			String category = request.getParameter("category");
			int grade = Integer.parseInt(request.getParameter("grade"));
			Subject obj = new Subject();
			obj.setName(name);
			obj.setCategory(category);
			obj.setGrade(grade);
			try {
				SubjectController.getInstance().Save(obj);
				response.getWriter().println("Saved!");
			} catch (Exception ex) {
				//error
			}
		} else if (action.equals("update")) {
			int subject_id = Integer.parseInt(request.getParameter("subject_id"));
			String name = request.getParameter("name");
			String category = request.getParameter("category");
			int grade = Integer.parseInt(request.getParameter("grade"));
			Subject obj = new Subject();
			obj.setSubject_id(subject_id);
			obj.setName(name);
			obj.setCategory(category);
			obj.setGrade(grade);
			try {
				SubjectController.getInstance().Update(obj);
				response.getWriter().println("Updated!");
			} catch (Exception ex) {
				//error
			}

		} else if (action.equals("delete")) {
			int subject_id = Integer.parseInt(request.getParameter("subject_id"));
			Subject obj = new Subject();
			obj.setSubject_id(subject_id);
			try {
				SubjectController.getInstance().Delete(obj);
				response.getWriter().println("Updated!");
			} catch (Exception ex) {
				//error
			}
		} else if (action.equals("serch")) {
			try {
				List<Subject> list = new ArrayList<>();
				List stringList = new ArrayList<>();

				list = SubjectController.getInstance().SearchAll();
				for (int i = 0; i < list.size(); i++) {
					String s = list.get(i).getSubject_id() + "_"+list.get(i).getName() + "_"+list.get(i).getCategory() + "_"+list.get(i).getGrade() + "_";
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