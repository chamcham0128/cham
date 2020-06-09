package controller;

import java.util.HashMap;
import java.util.Map;

import controller.product.CreateReviewController;
import controller.product.ShowCountController;
import controller.product.ShowReviewController;
import controller.product.WriteReviewController;
import controller.store.AddStockController;
import controller.store.DeleteReservation;
import controller.store.DeleteStockController;
import controller.store.SearchProductController;
import controller.store.ShowProductController;
import controller.store.ShowReservationController;
import controller.store.ShowStatisticController;
import controller.store.ShowStockController;
import controller.store.StoreReservationController;
import controller.store.UpdateStockController;
import controller.user.*;

public class RequestMapping {
	// 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
	private Map<String, Controller> mappings = new HashMap<String, Controller>();

	public void initMapping() {
		// 각 uri에 대응되는 controller 객체를 생성 및 저장
		// main
		mappings.put("/", new ForwardController("index.jsp"));
		mappings.put("/master/main", new MasterMainController());
		mappings.put("/customer/main", new CustomerMainController());

		// user
		mappings.put("/user/register/choose", new ForwardController("/user/chooseRegisterUser.jsp"));
		mappings.put("/user/register/master/form", new ForwardController("/user/mRegisterForm.jsp"));
		mappings.put("/user/register/master", new RegisterMasterController());
		mappings.put("/user/register/customer/form", new ForwardController("/user/cRegisterForm.jsp"));
		mappings.put("/user/register/customer", new RegisterUserController());

		mappings.put("/user/login/choose", new ForwardController("/user/chooseLoginUser.jsp"));
		mappings.put("/user/master/login", new LoginController());
		mappings.put("/user/login/master/form", new ForwardController("/user/mLoginForm.jsp"));
		mappings.put("/user/customer/login", new cLoginController());
		mappings.put("/user/login/customer/form", new ForwardController("/user/cLoginForm.jsp"));

		mappings.put("/user/logout", new LogoutController());

		mappings.put("/user/customer/mypage", new cMypageController());
		mappings.put("/user/customer/update/form", new cUpdateController());
		mappings.put("/user/customer/update", new cUpdateController());
		mappings.put("/user/customer/delete", new cDeleteController());

		mappings.put("/user/master/mypage", new mMypageController());
		mappings.put("/user/master/update/form", new mUpdateController());
		mappings.put("/user/master/update", new mUpdateController());
		mappings.put("/user/master/delete", new mDeleteController());

		// master
		mappings.put("/master/showStock", new ShowStockController());
		mappings.put("/master/addStock", new AddStockController());
		mappings.put("/master/deleteStock", new DeleteStockController());
		mappings.put("/master/updateStock", new UpdateStockController());

		mappings.put("/master/showReservation", new ShowReservationController());
		mappings.put("/master/showStatistic", new ShowStatisticController());
		mappings.put("/master/goStatistic", new ForwardController("/master/showStatistic.jsp"));
		mappings.put("/master/showCount", new ShowCountController());

		// product
		mappings.put("/product/showReview", new ShowReviewController());
		mappings.put("/product/review/form", new ForwardController("/product/showProduct.jsp"));
		mappings.put("/product/writeReview", new WriteReviewController());
		mappings.put("/product/createReview", new CreateReviewController());

		// store
		mappings.put("/store/searchProduct", new SearchProductController());
		mappings.put("/store/showProduct", new ShowProductController());

		mappings.put("/store/reservation", new StoreReservationController());
		mappings.put("/store/reservation/delete", new DeleteReservation());

	}

	public Controller findController(String uri) {
		// 주어진 uri에 대응되는 controller 객체를 찾아 반환
		return mappings.get(uri);
	}
}