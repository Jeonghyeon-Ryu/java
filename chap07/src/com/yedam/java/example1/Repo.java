package com.yedam.java.example1;

public class Repo {
	//필드
	private Customer[] dataList;
	private int listIndex;
	
	//생성자
	public Repo() {
		dataList = new Customer[100];
		listIndex = -1;
	}
	
	//메소드
	//Create
	public void insert(Customer customer) {
		dataList[++listIndex] = customer;
	}
	//Read
	public Customer[] selectAll() {
		return dataList;
	}
	public Customer selectOne(int customerId) {
		Customer selected = null;
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getCustomerId()==customerId) {
				selected = dataList[i];
				break;
			}
		}
		return selected;
	}
	//Update
	public void update(Customer customer) {
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getCustomerId()==customer.getCustomerId()) {
				dataList[i] = customer;
			}
		}
	}
	//Delete
	public void delete(Customer customer) {
		for(int i=0; i<=listIndex; i++) {
			if(dataList[i].getCustomerId()==customer.getCustomerId()) {
				dataList[i] = null;
			}
		}
		cleanDataList();
	}
	private void cleanDataList() {
		Customer[] temp = dataList;
		int tempIndex = listIndex;
		
		for(int i=0; i<=listIndex; i++) {
			if(temp[i]==null) {
				tempIndex++;
			}
			if(tempIndex<=listIndex) {
				dataList[i]=temp[tempIndex];
			} else {
				dataList[i]=null;
			}
		}
	}
}
