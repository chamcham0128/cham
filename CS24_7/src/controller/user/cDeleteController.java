package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

import model.dao.UserDAO;

public class cDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String deleteId = request.getParameter("id");

		UserDAO cUserdao = new UserDAO();
		cUserdao.cremove(deleteId);
		HttpSession session = request.getSession();
		session.removeAttribute(UserSessionUtils.USER_SESSION_KEY);
		session.invalidate();
		return "redirect:/"; // logout Ã³¸®

	}
}