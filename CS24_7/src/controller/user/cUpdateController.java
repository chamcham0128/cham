package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.User;
import model.dao.UserDAO;

public class cUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (request.getMethod().equals("GET")) {
			// GET request: 회원정보 수정 form 요청
			// 원래는 UpdateUserFormController가 처리하던 작업을 여기서 수행
			String updateId = request.getParameter("id");

			UserDAO cusdao = new UserDAO();
			User cuser = new User();

			cuser = cusdao.findcustomer(updateId);

			request.setAttribute("user", cuser);
			String birth = cuser.getBirth().split(" ")[0];
			cuser.setBirth(birth);

			return "/user/cUpdateForm.jsp"; // 검색한 사용자 정보를 update form으로 전송

		}

		if (request.getMethod().equals("POST")) {
			// POST request (회원정보가 parameter로 전송됨)
			String updateId = request.getParameter("id");

			UserDAO cusdao = new UserDAO();

			User cuser = new User(updateId, request.getParameter("name"), request.getParameter("phone"),
					request.getParameter("pwd"), request.getParameter("email"), request.getParameter("birth"),
					request.getParameter("gender"));

			cusdao.cupdate(cuser);

			return "redirect:/user/customer/mypage";
		}

		return null;
	}
}