package jp.co.aforce.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.dao.Logindao;

@WebServlet(urlPatterns = { "/servlet/LoginServlet" })
public class LoginServlet extends HttpServlet {
	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String url = null;
		HttpSession session = request.getSession();
		session.setAttribute("user_id", user_id);

		try {
			Logindao dao = new Logindao();

			if (dao.select(user_id, password)) {
				
				url = "/servlet/CheckServlet";
			} else {
				url = "../jsp/login.jsp";
				request.setAttribute("message", "*エラー IDもしくはパスワードが違います");
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
