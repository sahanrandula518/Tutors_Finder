//Sahan Randula - developersstack
package Servlets;


import Models.System_users;
import Controllers.System_usersController;
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


@WebServlet(name = "System_usersServlet", urlPatterns = {"/System_usersServlet"})


public class System_usersServlet extends HttpServlet {

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
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String user_type = request.getParameter("user_type");
			String email = request.getParameter("email");
			System_users obj = new System_users();
			obj.setName(name);
			obj.setUsername(username);
			obj.setPassword(password);
			obj.setUser_type(user_type);
			obj.setEmail(email);
			try {
				System_usersController.getInstance().Save(obj);
				response.getWriter().println("Saved!");
			} catch (Exception ex) {
				//error
			}
		} else if (action.equals("update")) {
			int system_user_id = Integer.parseInt(request.getParameter("system_user_id"));
			String name = request.getParameter("name");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String user_type = request.getParameter("user_type");
			String email = request.getParameter("email");
			System_users obj = new System_users();
			obj.setSystem_user_id(system_user_id);
			obj.setName(name);
			obj.setUsername(username);
			obj.setPassword(password);
			obj.setUser_type(user_type);
			obj.setEmail(email);
			try {
				System_usersController.getInstance().Update(obj);
				response.getWriter().println("Updated!");
			} catch (Exception ex) {
				//error
			}

		} else if (action.equals("delete")) {
			int system_user_id = Integer.parseInt(request.getParameter("system_user_id"));
			System_users obj = new System_users();
			obj.setSystem_user_id(system_user_id);
			try {
				System_usersController.getInstance().Delete(obj);
				response.getWriter().println("Updated!");
			} catch (Exception ex) {
				//error
			}
		} else if (action.equals("serch")) {
			try {
				List<System_users> list = new ArrayList<>();
				List stringList = new ArrayList<>();

				list = System_usersController.getInstance().SearchAll();
				for (int i = 0; i < list.size(); i++) {
					String s = list.get(i).getSystem_user_id() + "_"+list.get(i).getName() + "_"+list.get(i).getUsername() + "_"+list.get(i).getPassword() + "_"+list.get(i).getUser_type() + "_"+list.get(i).getEmail() + "_";
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