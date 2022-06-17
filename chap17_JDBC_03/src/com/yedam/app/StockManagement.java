package com.yedam.app;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.yedam.app.common.Info;
import com.yedam.java.history.History;
import com.yedam.java.history.HistoryDAO;
import com.yedam.java.product.Product;
import com.yedam.java.product.ProductDAO;

public class StockManagement {
	private ProductDAO productDAO = ProductDAO.getInstance();
	private HistoryDAO historyDAO = HistoryDAO.getInstance();
	private Scanner sc = new Scanner(System.in);
	
	public StockManagement() {
		while(true) {
			//메뉴출력
			menuPrint();
			//메뉴입력
			int menuNo = selectMenu();
			//각 기능별 실행
			if(menuNo==1) {
				inputProduct();
			} else if(menuNo==2) {
				productIn();
			} else if(menuNo==3) {
				productOut();
			} else if(menuNo==4) {
				productStock();
			} else if(menuNo==5) {
				allProductStock();
			} else if(menuNo==9) {
				exit();
			} else {
				inputError();
			}
		}
	}
	private void menuPrint() {
		System.out.println("================================================");
		System.out.println(" 1.제품등록  2.입고  3.출고  4.제품재고  5.전체재고  9.종료");
		System.out.println("================================================");
	}
	private int selectMenu() {
		int menuNo = 0;
		try {
			System.out.print("메뉴 선택 > ");
			menuNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자 형식으로 입력해주세요.");
		}
		return menuNo;
	}
	private void exit() {
		System.out.println("재고관리 시스템을 종료합니다.");
	}
	private void inputError() {
		System.out.println("메뉴선택이 잘못되었습니다.");
	}
	private void inputProduct() {
		Product product = inputAll();
		productDAO.insert(product);
	}
	private void productIn() {
		// 입고할 제품과 수량입력
		Info info = inputAmount();
		// 기존에 등록된 제품인지 확인
		Product product = productDAO.selectOne(info.getProductName());
		// 기존에 등록된 제품일 경우 입고처리
		if(product != null) {
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductAmount(info.getProductAmount());
			history.setProductCategory(1);
			historyDAO.insert(history);
		} else {
		// 기존에 등록되지 않은 경우 별도 안내
			System.out.println("해당 제품의 정보를 우선 등록해주세요.");
		}
	}
	private void productOut() {
		// 출고할 제품과 수량을 입력
		Info info = inputAmount();
		// 동록되어 있는 제품인지 확인
		Product product = productDAO.selectOne(info.getProductName());
		if(product == null) {
			System.out.println("해당 제품의 정보가 등록되어 있지 않습니다.");
			return;
		}
		// 재고량이 충분한 지 확인
		int stock = selectStock(product.getProductId());
		if(stock >= info.getProductAmount()) {
			// -1 조건을 모두 만족하는 경우 출고처리
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductAmount(info.getProductAmount());
			history.setProductCategory(2);
			historyDAO.insert(history);
		} else {
			// -2 각 조건이 만족되지 않는 경우 적합한 문구 출력
			System.out.println("재고량이 부족합니다.");
		}
	}
	private void productStock() {
		// 검색하고자 하는 제품정보 입력
		String productName = inputName();
		// 등록된 제품인지 확인
		Product product = productDAO.selectOne(productName);
		if(product == null) {
			System.out.println("해당 제품의 정보가 등록되어 있지 않습니다.");
			return;
		}
		// 해당제품 재고 출력
		int stock = selectStock(product.getProductId());
		System.out.println("[ 제품번호 : " + product.getProductId() + ", 제품이름 : " + product.getProductName() + ", 재고 : " + stock + " ]");
	}
	private void allProductStock() {
		Map<Integer, Integer> list = historyDAO.selectAll();
		Set<Integer> productList = list.keySet();
		for(int productId : productList) {
			Product product = productDAO.selectOne(productId);
			int stock = list.get(productId);
			System.out.println("[ 제품번호 : " + product.getProductId() + ", 제품이름 : " + product.getProductName() + ", 재고 : " + stock + " ]");
		}
	}
	private Product inputAll() {
		Product product = new Product();
		System.out.print("제품 이름 > ");
		product.setProductName(sc.nextLine());
		System.out.print("제품 가격 > ");
		product.setProductPrice(Integer.parseInt(sc.nextLine()));
		return product;
	}
	
	private Info inputAmount() {
		Info info = new Info();
		System.out.print("제품 이름 > ");
		info.setProductName(sc.nextLine());
		System.out.print("제품 수량 > ");
		info.setProductAmount(Integer.parseInt(sc.nextLine()));
		return info;
	}
	private String inputName() {
		System.out.print("제품 이름 > ");
		return sc.nextLine();
	}
	private int selectStock(int productId) {
		int stock = 0;
		stock = historyDAO.selectInAmount(productId) - historyDAO.selectOutAmount(productId);
		return stock;
	}
}
