package controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Product;
import model.dao.ProductDAO;

public class ShowReviewController implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pno = Integer.parseInt(request.getParameter("pno"));

		ProductDAO p = new ProductDAO();
		List<Product> showReview = p.showReview(pno);
		request.setAttribute("showReview", showReview);

		return "/product/showReview.jsp";
	}
}