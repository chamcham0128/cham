package controller.store;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Store;
import model.User;
import model.dao.StoreDAO;
import model.dao.UserDAO;

public class SearchProductController implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pname = request.getParameter("pname");
		pname = "%" + pname + "%";

		Store prod = new Store(pname, Integer.parseInt(request.getParameter("catno")));

		StoreDAO storeDAO = new StoreDAO();
		List<Store> productList = storeDAO.SearchProduct(prod);

		UserDAO cUserdao = new UserDAO();
		User cUser = new User();
		cUser = cUserdao.findcustomer(UserSessionUtils.getLoginUserId(request.getSession()));
		request.setAttribute("user", cUser);

		boolean newcount = storeDAO.UpdateCount(prod);

		if (productList != null && newcount != false) {

			request.setAttribute("productList", productList);
			return "/store/searchProduct.jsp";
		}

		return "/store/failsearchProduct.jsp";
	}

}