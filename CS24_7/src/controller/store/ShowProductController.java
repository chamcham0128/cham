package controller.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Store;
import model.User;
import model.dao.UserDAO;

public class ShowProductController implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Store prod = new Store(request.getParameter("location"), request.getParameter("sname"),
				request.getParameter("sbrand"), request.getParameter("phone"), request.getParameter("pname"),
				Integer.parseInt(request.getParameter("price")), request.getParameter("brand"),
				Integer.parseInt(request.getParameter("amount")), Integer.parseInt(request.getParameter("sno")),
				Integer.parseInt(request.getParameter("pno")));

		UserDAO cUserdao = new UserDAO();
		User cUser = new User();
		cUser = cUserdao.findcustomer(UserSessionUtils.getLoginUserId(request.getSession()));
		request.setAttribute("user", cUser);
		request.setAttribute("productList", prod);

		return "/product/showProduct.jsp";
	}
}
