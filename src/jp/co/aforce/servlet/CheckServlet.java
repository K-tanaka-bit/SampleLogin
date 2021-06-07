package jp.co.aforce.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.dao.Logindao;

@WebServlet(urlPatterns = { "/servlet/CheckServlet" })
public class CheckServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String url = null;

		if (session.getAttribute("user_id") != null) {

			url = "../jsp/success.jsp";

		} else {
			url = "login.jsp";

		}
		
		Logindao dao = new Logindao();
		List<String[]> nameList = null;
		
		try {

			nameList = dao.selectname();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		session.setAttribute("nameList",nameList );
		


		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}
}
