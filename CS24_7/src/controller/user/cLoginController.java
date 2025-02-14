package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.User;
import model.dao.UserDAO;
import model.service.PasswordMismatchException;
import model.service.UserNotFoundException;

public class cLoginController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("id");
		String password = request.getParameter("pwd");

		try {
			UserDAO cusdao = new UserDAO();
			User cuser = new User();
			cuser = cusdao.findcustomer(userId);

			if (cuser == null) {
				throw new UserNotFoundException(userId + "는 존재하지 않는 아이디입니다.");
			}

			if (!cuser.matchPassword(password)) {
				throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
			}

			if (cusdao.existingCuser(userId)) {
				// 세션에 사용자 이이디 저장
				HttpSession session = request.getSession();
				session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
			}

			return "redirect:/customer/main";
		} catch (Exception e) {
			/*
			 * UserNotFoundException이나 PasswordMismatchException 발생 시 다시 login form을 사용자에게
			 * 전송하고 오류 메세지도 출력
			 */
			request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
			return "/user/chooseRegisterUser.jsp";
		}
	}
}
