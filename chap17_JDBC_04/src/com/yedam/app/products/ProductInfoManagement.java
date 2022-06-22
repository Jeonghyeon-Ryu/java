package com.yedam.app.products;

import java.util.List;

import com.yedam.app.common.Management;

public class ProductInfoManagement extends Management{
	// 제품에 대한 정보를 등록, 수정, 삭제
	public ProductInfoManagement() {
		boolean role = selectRole();
		while(true) {
			menuPrint(role);
			int menuNo = menuSelect();
			if (menuNo==1 && role) {	//제품 정보 등록
				insertProductInfo();
			} else if (menuNo==2 && role) {	//제품 정보 수정 - 가격
				updateProductInfo();
			} else if (menuNo==3 && role) {	//제품 정보 삭제
				deleteProductInfo();
			} else if (menuNo==4) {	//제품 정보 조회
				selectOne();
			} else if (menuNo==5) {	//제품 정보 전체 조회
				selectAll();
			} else if (menuNo==9) {	//뒤로가기
				exit();
				break;
			} else {	// 에러
				showInputError();
			}
		}
	}
	private void menuPrint(boolean role) {
		String menu = "";
		if(role) {
			menu =  " 1.제품등록  2.제품수정  3.제품삭제 ";
		}
		menu += " 4.제품검색  5.전체조회  9.뒤로가기";
		System.out.println("========================================================");
		System.out.println(menu);
		System.out.println("========================================================");
	}
	protected void menuPrint() {
		System.out.println("========================================================");
		System.out.println(" 1.제품등록  2.제품수정  3.제품삭제  4.제품검색  5.전체조회  9.뒤로가기");
		System.out.println("========================================================");
	}
	private void insertProductInfo() {
		// 제품 정보 입력
		Product product = inputAll();
		// DB 저장
		pDAO.insert(product);
	}
	private void updateProductInfo() {
		// 제품 이름 입력
		String productName = inputName();
		// 제품 정보 검색
		Product product = pDAO.selectOne(productName);
		if(product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		// 수정할 정보 입력
		product = inputUpdateInfo(product);
		// DB 수정
		pDAO.updateInfo(product);
	}
	private void deleteProductInfo() {
		// 제품 이름 입력
		String productName = inputName();
		// 제품 정보 검색 
		// -1 Products 테이블 정보
		Product product = pDAO.selectOne(productName);
		if(product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		// -2 입고내역에서 검색 -> 입고내역에서는 삭제하지 않음
		boolean isSelected = rDAO.selectInfo(product.getProductId());
		
		// DB 삭제
		if(!isSelected) {
			pDAO.delete(product.getProductId());
		} else {
			System.out.println("거래내역이 존재합니다.");
		}
			
	}
	private Product inputAll() {
		Product product = new Product();
		product.setProductName(inputName());
		System.out.print(" 제품 가격 : ");
		product.setProductPrice(Integer.parseInt(sc.nextLine()));
		return product;
	}
	private String inputName() {
		System.out.print(" 제품 이름 : ");
		return sc.nextLine();
	}
	private Product inputUpdateInfo(Product product) {
		System.out.println("기존 이름 : " + product.getProductName());
		System.out.print(" 수정(수정하지 않을 경우 0) : ");
		String name = sc.nextLine();
		if(!name.equals("0")) {
			product.setProductName(name);
		}
		System.out.println("기존 가격 : " + product.getProductPrice());
		System.out.print(" 수정(수정하지 않을 경우 -1) : ");
		int price = Integer.parseInt(sc.nextLine());
		if(price > -1) {
			product.setProductPrice(price);
		}
		
		return product;
	}
	private void selectOne() {
		String productName = inputName();
		Product product = pDAO.selectOne(productName);
		if(product==null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		System.out.println(product);
	}
	
	private void selectAll() {
		List<Product> list = pDAO.selectAll();
		if(list.size()==0) {
			System.out.println("등록된 제품이 없습니다.");
			return;
		}
		list.forEach( x -> System.out.println(x) );
	}
}
