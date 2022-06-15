package com.yedam.java.ch0701_GuessNumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Server extends Observer implements Runnable {
	private File userFile = new File("C:\\Users\\admin\\git\\java\\chap07\\src\\com\\yedam\\java\\ch0701_GuessNumber\\UserData.txt");
	private File blockUserFile = new File("C:\\Users\\admin\\git\\java\\chap07\\src\\com\\yedam\\java\\ch0701_GuessNumber\\BlockUserData.txt");
	private List<User> users = new ArrayList<User>(); // 0번째 MAIN 유저
	private List<User> blockUserList = new ArrayList<User>();
	private List<User> liveUser = new ArrayList<User>();
	private static Server server = new Server();
	// *************** Constructor 영역 !!
	private Server() {
		if(!userFile.exists()||!blockUserFile.exists()) {
			if(!blockUserFile.exists())
				try {
					blockUserFile.createNewFile();
					System.out.println("서버 : 파일 생성 완료");
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(!userFile.exists())
				try {
					userFile.createNewFile();
					System.out.println("서버 : 파일 생성 완료");
					User mainUser = new User("MAIN","MAIN","MAIN");
					createUser(mainUser);
				} catch (IOException e) {
					e.printStackTrace();
				}
		} else {
			try {
				readDatabase();
				System.out.println("서버 : 데이터 읽기 완료");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// *************** Method 영역 !! 
	public static Server getInstance() {
		return server;
	}
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
		br.close();
		fis.close();
	}
	
	// 요청 메세지 받을 유저 등록(attach) / 삭제(detach)
	public void attach(User user) {
		liveUser.add(user);
	}
	public void detach(User user) {
		liveUser.remove(user);
	}
	// 전체 메세지 전송
	public void notifyObservers(Data data) {
		for(Observer o: liveUser)
			o.receive(data);
	}
	// 단일유저 메세지 전송
	void postMsg(String msg) {
		
	}
	// 요청 확인
	public void run() {
		while(true) {
			for(User u : liveUser) {
				if(u.msg == "")
					continue;
				decrypt(u, u.msg);
				System.out.println("데이터 읽기 완료");
				u.msg="";
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// 요청 세부 확인
	private void decrypt(User o, String msg) {
		String[] splitMsg = msg.split("#");
		System.out.println(splitMsg[0]+" "+splitMsg[1]+" "+splitMsg[2]+ " " + splitMsg[3]);
		if(splitMsg[0] == "0") {			// Admin Message
			if(splitMsg[1]=="1") {				// getUsers
				
			} else if(splitMsg[1]=="2") {		// getRank
				
			} else if(splitMsg[1]=="3") {		// blockUser
				blockUser(users.get(Integer.parseInt(splitMsg[2])));
			}
		} else if(splitMsg[0] == "1") {		// User Message
			if(splitMsg[1]=="0") {				// withdrawal User
				removeUser(users.get(Integer.parseInt(splitMsg[2])));
			} else if(splitMsg[1]=="1") {		// setPw
				updatePw(users.get(Integer.parseInt(splitMsg[2])),splitMsg[3]);
			} else if(splitMsg[1]=="2") {		// setName
				updateName(users.get(Integer.parseInt(splitMsg[2])),splitMsg[3]);
			}
		} else if(splitMsg[0] == "2") {		// Game System Message
			if(splitMsg[1]=="1") {				// setRank
			}
		} else if(splitMsg[0] == "3") {		// 
			System.out.println("0번 인식 완료");
			if(splitMsg[1]=="1") {				// 로그인 시도
				System.out.println("decrypt 시도");
				int index = selectUser(splitMsg[2],splitMsg[3]);
				if(index>=0) {
					Data data = new Data(true,users.get(index));
					o.data = data;
				}
				System.out.println("decyrpt 완료");
				System.out.println(o.data.approval+ " " + o.data.user.getId());
			}
		}
	}
	
	
	@SuppressWarnings("unused")
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
	@SuppressWarnings("unused")
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
	
	public int selectUser(String id, String pw) {
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getId()==id)
				if(users.get(i).getPw()==pw)
					return i;
		}
		return -1;
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

	public void shutdown() throws IOException {
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
