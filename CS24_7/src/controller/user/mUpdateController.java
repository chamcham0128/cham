package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Store;
import model.User;
import model.dao.StoreDAO;
import model.dao.UserDAO;

public class mUpdateController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		if (request.getMethod().equals("GET")) {
			String updateId = request.getParameter("id");

			UserDAO musdao = new UserDAO();
			User muser = new User();

			muser = musdao.findmaster(updateId);

			request.setAttribute("user", muser);
			String birth = muser.getBirth().split(" ")[0];
			muser.setBirth(birth);

			Store store = new Store();
			StoreDAO storeDAO = new StoreDAO();
			store = storeDAO.findStore(updateId);
			request.setAttribute("store", store);

			return "/user/mUpdateForm.jsp";
		}

		if (request.getMethod().equals("POST")) {
			String updateId = request.getParameter("id");

			UserDAO musdao = new UserDAO();

			User muser = new User(updateId, request.getParameter("name"), request.getParameter("phone"),
					request.getParameter("pwd"), request.getParameter("birth"), request.getParameter("licenseNo"),
					request.getParameter("email"), 0);

			musdao.mupdate(muser);

			StoreDAO storeDAO = new StoreDAO();
			String sbrand = request.getParameter("storename").split(" ")[0];
			String sname = request.getParameter("storename").split(" ")[1];

			Store store = new Store(request.getParameter("location"), sname, sbrand, request.getParameter("sphone"),
					updateId);
			storeDAO.supdate(store);

			return "redirect:/user/master/mypage";
		}

		return null;
	}
}