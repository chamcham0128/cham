package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.User;
import model.dao.UserDAO;

public class CustomerMainController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인 여부 확인
		if (!UserSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/user/login/customer/form"; // login form 요청으로 redirect
		}

		UserDAO cUserdao = new UserDAO();
		User cUser = new User();
		cUser = cUserdao.findcustomer(UserSessionUtils.getLoginUserId(request.getSession()));

		// 로그인한 현재 id 저장
		request.setAttribute("user", cUser);
		request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));

		return "/";
	}

}
