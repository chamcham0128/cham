package controller.store;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Store;
import model.dao.StoreDAO;

public class UpdateStockController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Store store = new Store(Integer.parseInt(request.getParameter("sno")),
				Integer.parseInt(request.getParameter("pno")), request.getParameter("pname"),
				Integer.parseInt(request.getParameter("update_amount")));
		store.setId(UserSessionUtils.getLoginUserId(request.getSession()));

		StoreDAO storeDAO = new StoreDAO();
		storeDAO.UpdateStockAmount(store);
		List<Store> stockList = storeDAO.LookupOurStore(store);
		int sno = stockList.get(0).getSno();

		request.setAttribute("sno", sno);
		request.setAttribute("stockList", stockList);

		return "/master/showStock.jsp";
	}

}
