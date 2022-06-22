package com.yedam.app.deal;

import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.Management;
import com.yedam.app.products.Product;

//제품 입고, 출고, 재고 관리 프로그램
public class ProductStockManagement extends Management{
	public ProductStockManagement() {
		boolean role = selectRole();
		while(true) {
			menuPrint(role);
			int menuNo = menuSelect();
			if(menuNo == 1 && role) {			// 입고
				productIn();
			} else if(menuNo == 2 && role) {	// 출고
				productOut();
			} else if(menuNo == 3) {	// 재고
				productStock();
			} else if(menuNo == 4 && role) {	// 거래내역
				productDeal();
			} else if(menuNo == 9) {	// 종료(뒤로가기)
				exit();
				break;				
			} else {
				showInputError();
			}
		}
		
	}
	private void menuPrint(boolean role) {
		String menu = "";
		if(role) { menu =  " 1.입고  2.출고 "; }
		menu += " 3.재고 ";
		if(role) { menu +=  " 4.거래내역 "; }
		menu += " 9.뒤로가기";
		System.out.println("========================================================");
		System.out.println(menu);
		System.out.println("========================================================");
	}
	protected void menuPrint() {
		System.out.println("======================================");
		System.out.println(" 1.입고  2.출고  3.재고  4.거래내역  9.뒤로가기");
		System.out.println("======================================");
	}
	
	private void productIn() {
		// 제품이름, 수량 입력
		DealInfo info = inputAmount();
		// 제품 등록 여부 확인
		Product product = pDAO.selectOne(info.getProductName());
		if(product==null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		// 입고이력 등록, 제품재고 수정
		info.setProductId(product.getProductId());
		rDAO.insert(info);
		
		updateProductStock(product.getProductId());
	}
	
	private void productOut() {
		// 제품이름, 수량 입력
		DealInfo info = inputAmount();
		// 제품 등록 여부 확인
		Product product = pDAO.selectOne(info.getProductName());
		if(product == null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		// 재고와 출고 수량 비교
		if(product.getProductStock() < info.getProductAmount()) {
			System.out.println("재고량이 부족합니다.");
			return;
		}
		// 재고 > 출고 경우 출고이력 등록
		info.setProductId(product.getProductId());
		tDAO.insert(info);
		// 재품재고 수정
		updateProductStock(product.getProductId());
	}
	private DealInfo inputAmount() {
		DealInfo info = new DealInfo();
		//이름
		System.out.print("제품 이름 : ");
		info.setProductName(sc.nextLine());
		//수량
		System.out.print("제품 수량 : ");
		info.setProductAmount(Integer.parseInt(sc.nextLine()));
		return info;
	}
	private void updateProductStock(int productId) {
		// DealInfo 매개변수로 받을 경우 : DB접근 줄어듬 -> 정확성 ?? 별반 다를게 없지않나
//		Product product = new Product();
//		product.setProductId(info.getProductId());
//		product.setProductName(info.getProductName());
//		product.setProductStock(product.getProductStock()-info.getProductAmount());
//		pDAO.updateInfo(product);
		
		// rDAO tDAO 접근해서 전체 출고량 SQL 조회 후 pDAO 로 입고 -> 정확성 좋음.
		// 입고량 전체 조회
		int inAmount = rDAO.selectAmount(productId);
		// 출고량 전체 조회
		int outAmount = tDAO.selectAmount(productId);
		// 재고(입고량-출고량)
		Product product = new Product();
		product.setProductId(productId);
		product.setProductStock(inAmount-outAmount);
		pDAO.updateStock(product);
	}
	private void productStock() {
		// 제품이름 입력
		String productName = inputName();
		// 제품 등록 여부 확인
		Product product = pDAO.selectOne(productName);
		if(product == null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		// 제품 재고 출력
		System.out.println(product);
	}
	private String inputName() {
		System.out.print("제품 이름 > ");
		return sc.nextLine();
	}

	private void productDeal() {
		// 제품이름 입력
		String productName = inputName();
		// 제품 등록 여부 확인
		Product product = pDAO.selectOne(productName);
		if(product == null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		// 재품 입고 및 출고 이력 출력
		// 입출고 조회 선택
		dealMenuPrint();
		int choice = menuSelect();
		List<DealInfo> list = new ArrayList<>();
		if(choice == 1) {
			list = rDAO.SelectAll(product.getProductId());
			System.out.println("========= 입고내역");
		} else if(choice==2) {
			list = tDAO.SelectAll(product.getProductId());
			System.out.println("========= 출고내역");
		}
		list.forEach( x -> System.out.println(x) );
	}
	private void dealMenuPrint() {
		System.out.println("==================");
		System.out.println(" 1.입고조회  2.출고조회");
		System.out.println("==================");
	}
	
}
