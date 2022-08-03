package crawling;

import java.sql.Date;

public class Room {
	private int roomId;
	private int accId;
	private String name;
	private String price;
	private int isReservation;
	private Date reservationTime;
	private String info;
	
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", accId=" + accId + ", name=" + name + ", price=" + price
				+ ", isReservation=" + isReservation + ", reservationTime=" + reservationTime + ", info=" + info + "]";
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getIsReservation() {
		return isReservation;
	}
	public void setIsReservation(int isReservation) {
		this.isReservation = isReservation;
	}
	public Date getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
