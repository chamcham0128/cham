package controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Product;

import model.dao.ProductDAO;

public class ShowCountController implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProductDAO productDAO = new ProductDAO();
		List<Product> countList = productDAO.calproductRank();

		if (countList != null) {
			request.setAttribute("countList", countList);
			return "/master/showCount.jsp";
		}

		return "/master/main_m.jsp";
	}

}