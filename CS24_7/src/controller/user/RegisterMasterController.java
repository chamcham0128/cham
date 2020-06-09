package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Store;
import model.User;
import model.dao.StoreDAO;
import model.dao.UserDAO;
import model.service.ExistingUserException;

public class RegisterMasterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = new User(request.getParameter("id"), request.getParameter("name"), request.getParameter("phone"),
				request.getParameter("pwd"), request.getParameter("birth"), request.getParameter("licenseno"),
				request.getParameter("email"), 0);

		String sbrand = request.getParameter("storename").split(" ")[0];
		String sname = request.getParameter("storename").split(" ")[1];

		Store store = new Store(request.getParameter("location"), sname, sbrand, request.getParameter("sphone"),
				request.getParameter("id"));
		try {
			UserDAO userDAO = new UserDAO();
			StoreDAO storeDAO = new StoreDAO();
			if (userDAO.existingMuser(user.getId()) == true) {
				throw new ExistingUserException(user.getId() + "�� �����ϴ� ���̵��Դϴ�.");
			}

			userDAO.createMaster(user);
			storeDAO.createStore(store);
			return "/user/mLoginForm.jsp";

		} catch (/* ExistingUser */Exception e) {
			request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", user);
			return "/user/chooseRegisterUser.jsp";
		}
	}
}