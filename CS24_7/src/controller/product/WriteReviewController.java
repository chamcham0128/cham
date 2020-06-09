package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class WriteReviewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pno = Integer.parseInt(request.getParameter("pno"));
		request.setAttribute("pno", pno);

		return "/product/writeReview.jsp";
	}

}