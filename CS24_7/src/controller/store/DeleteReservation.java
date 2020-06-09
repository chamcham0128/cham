package controller.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

import model.Store;
import model.dao.StoreDAO;

public class DeleteReservation implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Store store = new Store(Integer.parseInt(request.getParameter("sno")), request.getParameter("pname"),
				request.getParameter("id"));

		StoreDAO storeDAO = new StoreDAO();

		storeDAO.plusStock(store);
		storeDAO.deleteRes(store);

		return "redirect:/user/customer/mypage";
	}

}
