package controller.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Store;
import model.User;
import model.dao.StoreDAO;
import model.dao.UserDAO;

public class StoreReservationController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Store store = new Store(request.getParameter("userId"),
				Integer.parseInt(request.getParameter("sno")), Integer.parseInt(request.getParameter("pno")),
				request.getParameter("pname"), request.getParameter("gender"),
				User.calAge(request.getParameter("birth")), Integer.parseInt(request.getParameter("pcount")),
				Integer.parseInt(request.getParameter("amount")), request.getParameter("location"),
				request.getParameter("sbrand"), request.getParameter("sname"), request.getParameter("phone"),
				Integer.parseInt(request.getParameter("price")), request.getParameter("brand"));

		StoreDAO storeDAO = new StoreDAO();
		storeDAO.InsertRes(store);
		Store s = storeDAO.minusStock(store);
		request.setAttribute("productList", s);

		UserDAO cUserdao = new UserDAO();
		User cUser = new User();
		cUser = cUserdao.findcustomer(UserSessionUtils.getLoginUserId(request.getSession()));
		request.setAttribute("user", cUser);

		return "/product/showProduct.jsp";

	}
}