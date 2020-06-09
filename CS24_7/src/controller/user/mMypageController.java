package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Store;
import model.User;
import model.dao.StoreDAO;
import model.dao.UserDAO;

public class mMypageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!UserSessionUtils.hasLogined(request.getSession())) {
			return "redirect:/user/login/master/form";
		}

		UserDAO mUserdao = new UserDAO();
		User mUser = new User();
		mUser = mUserdao.findmaster(UserSessionUtils.getLoginUserId(request.getSession()));
		String birth = mUser.getBirth().split(" ")[0];
		mUser.setBirth(birth);
		request.setAttribute("user", mUser);

		Store store = new Store();
		StoreDAO storeDAO = new StoreDAO();
		store = storeDAO.findStore(UserSessionUtils.getLoginUserId(request.getSession()));
		request.setAttribute("store", store);

		return "/user/mMypage.jsp";
	}
}