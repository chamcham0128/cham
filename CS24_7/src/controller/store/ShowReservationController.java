package controller.store;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Store;
import model.dao.StoreDAO;

public class ShowReservationController implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		StoreDAO storeDAO = new StoreDAO();
		String userId = UserSessionUtils.getLoginUserId(request.getSession());
		List<Store> reservationList = storeDAO.showReservation(userId);

		request.setAttribute("reservationList", reservationList);

		return "/master/showReservation.jsp";
	}
}