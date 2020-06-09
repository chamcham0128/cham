package controller.store;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Store;
import model.dao.*;

public class ShowStatisticController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StoreDAO storeDAO = new StoreDAO();

		List<Store> store = new ArrayList<Store>();
		store = storeDAO.SelectStatistic();

		for (int i = 0; i < store.size(); i++) {
			storeDAO.InsertStatistic(store.get(i));
		}
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");

		List<Store> stList = storeDAO.showStatistic(age, gender);

		request.setAttribute("stList", stList);
		return "/master/showStatistic.jsp";

	}

}