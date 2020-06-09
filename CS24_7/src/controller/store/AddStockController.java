package controller.store;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Store;
import model.dao.StoreDAO;

public class AddStockController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StoreDAO storeDAO = new StoreDAO();

		Store store = new Store();
		store.setSno(Integer.parseInt(request.getParameter("sno")));
		store.setPname(request.getParameter("pname"));
		store.setAmount(Integer.parseInt(request.getParameter("amount")));
		store.setId(UserSessionUtils.getLoginUserId(request.getSession()));

		int pno = storeDAO.findStock(store);
		if (pno != 0)
			store.setPno(pno);
		else
			return "redirect:/master/showStock";

		storeDAO.InsertStock(store);
		List<Store> stockList = storeDAO.LookupOurStore(store);
		int sno = stockList.get(0).getSno();

		request.setAttribute("sno", sno);
		request.setAttribute("stockList", stockList);

		return "/master/showStock.jsp";
	}

}