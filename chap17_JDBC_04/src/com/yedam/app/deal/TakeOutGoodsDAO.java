package com.yedam.app.deal;

public class TakeOutGoodsDAO {
	private static TakeOutGoodsDAO tDAO = null;
	private TakeOutGoodsDAO() {	}
	public static TakeOutGoodsDAO getInstance() {
		if(tDAO == null) {
			tDAO = new TakeOutGoodsDAO();
		}
		return tDAO;
	}
}
