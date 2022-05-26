package com.yedam.java.ch0701_GuessNumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server extends Observer implements Runnable {
	private File userFile = new File("D:\\dev\\workspace\\chap07\\src\\com\\yedam\\java\\ch0701_GuessNumber\\UserData.txt");
	private File blockUserFile = new File("D:\\dev\\workspace\\chap07\\src\\com\\yedam\\java\\ch0701_GuessNumber\\BlockUserData.txt");
	private List<Observer> observers = new ArrayList<Observer>();
	private List<User> users = new ArrayList<User>();
	private List<User> blockUserList = new ArrayList<User>();
	// *************** Constructor 영역 !!
	public Server() throws IOException {
		if(!userFile.exists()) {
			userFile.createNewFile();
		} else {
			readDatabase();
		}
	}
	
	// *************** Method 영역 !! 
	public void readDatabase() throws IOException {
		String line;
		FileInputStream fis = new FileInputStream(userFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		while((line = br.readLine()) != null) {
			String[] temp = line.split("#");
			User tempUser = new User(temp[0],temp[1],temp[2],Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),Integer.parseInt(temp[5]));
			users.add(tempUser);
		}
		fis = new FileInputStream(blockUserFile);
		br = new BufferedReader(new InputStreamReader(fis));
		while((line = br.readLine()) != null) {
			String[] temp = line.split("#");
			User tempUser = new User(temp[0],temp[1],temp[2],Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),Integer.parseInt(temp[5]));
			blockUserList.add(tempUser);
		}
	}
	
	// 요청 메세지 받을 유저 등록(attach) / 삭제(detach)
	public void attach(Observer observer) {
		observers.add(observer);
	}
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	// 전체 메세지 전송
	public void notifyObservers(String msg) {
		for(Observer o: observers)
			o.receive(msg);
	}
	// 단일유저 메세지 전송
	void postMsg(String msg) {
		
	}
	// 요청 확인
	public void run() {
		for(Observer o : observers) {
			if(o.msg == " ")
				continue;
			decrypt(o, o.msg);
		}
	}
	// 요청 세부 확인
	private String decrypt(Observer o, String msg) {
		String[] splitMsg = msg.split("#");
		if(splitMsg[0] == "0") {			// Admin Message
			if(splitMsg[1]=="1") {				// getUsers
				return "유저 불러오기 완료";
			} else if(splitMsg[1]=="2") {		// getRank
				return "랭킹 불러오기 완료";
			} else if(splitMsg[1]=="3") {		// blockUser
				blockUser(users.get(Integer.parseInt(splitMsg[2])));
				return "유저 차단 완료";
			}
		} else if(splitMsg[0] == "1") {		// User Message
			if(splitMsg[1]=="0") {				// withdrawal User
				removeUser(users.get(Integer.parseInt(splitMsg[2])));
				return "탈퇴 완료";
			} else if(splitMsg[1]=="1") {		// setPw
				updatePw(users.get(Integer.parseInt(splitMsg[2])),splitMsg[3]);
				return "비밀번호 변경 완료";
			} else if(splitMsg[1]=="2") {		// setName
				updateName(users.get(Integer.parseInt(splitMsg[2])),splitMsg[3]);
				return "이름 변경 완료";
			}
		} else if(splitMsg[0] == "2") {		// Game System Message
			if(splitMsg[1]=="1") {				// setRank
				return "랭킹 등록 완료";
			}
		}
		return "잘못된 요청입니다.";
	}
	
	
	private String getRank() {
		sortScore();
		String result = "";
		for(int i=0; i<users.size(); i++) {
			if(i==10)
				break;
			result = "랭크 " + (i+1) + " : " + users.get(i).getId() + " --- 승률 : " + (int)((users.get(i).getScore()[1]/(double)users.get(i).getScore()[0])*100) +"%\n";
		}
		return result;
	}
	private void sortScore() {
		User temp;
		for(int i=users.size()-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				int win = users.get(j).getScore()[1];
				int loose = users.get(j).getScore()[0];
				int win2 = users.get(j+1).getScore()[1];
				int loose2 = users.get(j+1).getScore()[0];
				if(((double)win/loose)>((double)win2/loose)) {
					temp = users.get(j);
					users.add(j+2,temp);
					users.remove(j);
				}
			}
		}
	}
	
	public boolean createUser(User user) {
		return users.add(user);
	}
	private boolean blockUser(User user) {
		return blockUserList.add(user);
	}
	
	private boolean removeUser(User user) {
		return users.remove(user);
	}
	private boolean updatePw(User user, String pw) {
		try {
			int index = users.indexOf(user);
			user.setPw(pw);
			users.set(index, user);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	private boolean updateName(User user, String name) {
		try {
			int index = users.indexOf(user);
			user.setName(name);
			users.set(index, user);
		} catch(Exception e) {
			return false;
		}
		return true;
	}

	private void shutdown() throws IOException {
		FileOutputStream fos = new FileOutputStream(userFile);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		for(int i=0; i<users.size(); i++) {
			User temp = users.get(i);
			// 아이디 # 비밀번호 # 이름 # 일련번호 # 스코어 패 # 스코어 승
			String line = temp.getId()+"#"+temp.getPw()+"#"+temp.getName()+"#"+temp.getNumber()+"#"+temp.getScore()[0]+"#"+temp.getScore()[1];
			bw.write(line);
			bw.newLine();
		}
		bw.close();
		fos.close();
	}
}
