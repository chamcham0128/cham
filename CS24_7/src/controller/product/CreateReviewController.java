package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Product;
import model.dao.ProductDAO;

public class CreateReviewController implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pno = Integer.parseInt(request.getParameter("pno"));
		Product prod = new Product(pno, request.getParameter("content"), Float.valueOf(request.getParameter("gpa")),
				request.getParameter("id"));

		// Product에 리뷰 추가하기
		ProductDAO p = new ProductDAO();
		p.createReview(prod);
		request.setAttribute("pno", pno);

		return "/product/showReview";
	}
}