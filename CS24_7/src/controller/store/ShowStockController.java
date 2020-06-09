package controller.store;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Store;
import model.dao.StoreDAO;

public class ShowStockController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StoreDAO storeDAO = new StoreDAO();
		Store store = new Store();
		store.setId(UserSessionUtils.getLoginUserId(request.getSession()));
		List<Store> stockList = storeDAO.LookupOurStore(store);

		int sno = stockList.get(0).getSno();
		request.setAttribute("stockList", stockList);
		request.setAttribute("sno", sno);

		return "/master/showStock.jsp";
	}

}
