package com.yedam.java.homework2;

public class RPGgame implements Keypad{
	private int mode;
	
	public RPGgame() {
		this.mode = NORMAL_MODE;
		System.out.println("RPGgame 실행");
	}

	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 위쪽으로 이동한다.");
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 아래쪽으로 이동한다.");
	}

	@Override
	public void rightUpButton() {
		if(mode==NORMAL_MODE) {
			System.out.println("캐릭터가 한칸단위로 점프한다.");
		} else {
			System.out.println("캐릭터가 두칸단위로 점프한다.");
		}
	}

	@Override
	public void rightDownButton() {
		if(mode==NORMAL_MODE) {
			System.out.println("캐릭터가 일반 공격.");
		} else {
			System.out.println("캐릭터가 HIT 공격.");
		}
	}

	@Override
	public void changeMode() {
		mode = mode^1;
		if(mode==NORMAL_MODE) {
			System.out.println("현재모드 : NORMAL_MODE");
		} else {
			System.out.println("현재모드 : HARD_MODE");
		}
	}
}
