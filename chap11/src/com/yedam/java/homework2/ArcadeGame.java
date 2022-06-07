package com.yedam.java.homework2;

public class ArcadeGame implements Keypad {
	private int mode;
	
	public ArcadeGame() {
		this.mode = NORMAL_MODE;
		System.out.println("ArcadeGame 실행");
	}
	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 앞쪽으로 이동한다.");
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 뒤쪽으로 이동한다.");
	}

	@Override
	public void rightUpButton() {
		if(mode==NORMAL_MODE) {
			System.out.println("캐릭터가 일반 공격.");
		} else {
			System.out.println("캐릭터가 연속 공격.");
		}
	}

	@Override
	public void rightDownButton() {
		if(mode==NORMAL_MODE) {
			System.out.println("캐릭터가 HIT 공격.");
		} else {
			System.out.println("캐릭터가 Double HIT 공격.");
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
