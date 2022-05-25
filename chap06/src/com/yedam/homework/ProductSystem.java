package com.yedam.homework;

public class ProductSystem {
	// 필드
	private int index=-1;
	private Product[] product;
	private static ProductSystem instance = new ProductSystem();
	
	//	생성자 : 싱글톤 적용
	private ProductSystem() { }
	
	//	메소드 : 싱글톤 적용
	static ProductSystem getProductSystem() {
		return instance;
	}
	//	1. 상품 수 입력
	public void setListSize(int n) {
		product = new Product[n];
	}
	//	2. 상품 및 가격입력
	public void putProduct(String name, int price) {
		Product tmp = new Product();
		tmp.setName(name);
		tmp.setPrice(price);
		product[++index] = tmp;
	}
	//	3. 제품별 가격
	public void printList() {
		for(int i=0; i<=index; i++) {
			System.out.println(product[i].getName() + " : " + product[i].getPrice());
		}
	}
	//	4. 분석
	public void analyzeProduct() {
		int max = 0;
		int maxIndex=-1;
		int sumExcludeMax = 0;
		for(int i=0; i<=index; i++) {
			if(max<product[i].getPrice()) {
				max = product[i].getPrice();
				maxIndex = i;
			}
			sumExcludeMax += product[i].getPrice();	// 반복문 한번만 돌리려고 여기서 총합먼저 구함.
		}
		if(maxIndex==-1)
			System.out.println("최고가격 계산 오류");
		else
			System.out.println("최고가격인 제품명 : " + product[maxIndex].getName());
		
		// 최고가격 제외 제품 총합.
		sumExcludeMax = sumExcludeMax - product[maxIndex].getPrice();
		System.out.println("최고가격 제외 제품가격 총합 : " + sumExcludeMax);
	}
	//	4-1. 최고가격을 가지고 있는 제품정보
	public Product getMaxPriceInfo() {
		Product maxInfo = product[0];
		for(int i=1; i<=index; i++) {
			if(maxInfo.getPrice()<product[i].getPrice())
				maxInfo = product[i];
		}
		return maxInfo;
	}
	public int getTotalPrice() {
		int sum = 0;
		for(Product temp : product)
			sum += temp.getPrice();
		int result = sum-getMaxPriceInfo().getPrice();
		
		///////////////////////////
		Product maxInfo = getMaxPriceInfo();
		for(Product temp : product) {
			if(temp.getPrice() == maxInfo.getPrice())
				continue;
			sum += temp.getPrice();
		}
		
		return result;
	}
}
