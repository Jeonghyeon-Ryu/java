package com.yedam.java.history;

public class History {
	private int productId;
	private int productCategory;
	// Oracle 에서 Check 조건으로 1/2 로 구분 > 오라클에는 Boolean 타입이 없다
	// 1:입고 , 2:출고
	private int productAmount;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	
}
