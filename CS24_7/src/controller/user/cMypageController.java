package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Store;
import model.User;
import model.dao.StoreDAO;
import model.dao.UserDAO;

public class cMypageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDAO cUserdao = new UserDAO();
		User cUser = new User();
		cUser = cUserdao.findcustomer(UserSessionUtils.getLoginUserId(request.getSession()));
		String birth = cUser.getBirth().split(" ")[0];
		cUser.setBirth(birth);
		request.setAttribute("user", cUser);

		StoreDAO storeDAO = new StoreDAO();
		List<Store> pnameList = storeDAO.showPname(cUser);
		request.setAttribute("pnameList", pnameList);

		return "/user/cMypage.jsp"; // 사용자 보기 화면으로 이동
	}
}
