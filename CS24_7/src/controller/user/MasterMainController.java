package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class MasterMainController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인 여부 확인
		if (!UserSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/user/login/master/form"; // login form 요청으로 redirect
		}

		request.setAttribute("curUserId", UserSessionUtils.getLoginUserId(request.getSession()));

		// 사용자 리스트 화면으로 이동(forwarding)
		return "/master/main_m.jsp";

	}

}
