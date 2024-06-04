package ch12;

/**
 * 상수의 구성 정보
 *   - 불연속적인 상수값
 *   - 기능적인 메소드
 *   - 기능 구현 제한(강제)
 * 
 */

enum Transportation {
	BUS(100) {
		// 요금 계산 기능
		int fare(int distance) {
			return distance * BASIC_FARE;//BASIC_FARE = 100;
		}
	},
	TRAIN(150) {
		// 요금 계산 기능
		int fare(int distance) {
			return distance * BASIC_FARE;//BASIC_FARE = 150;
		}
	};
	
	private final int basicFare;
	final int BASIC_FARE;
	
	Transportation(int basicFare) {
		this.basicFare = basicFare;
		BASIC_FARE = basicFare;
	}
	
	public int getBasicFare() { return basicFare; }
	
	abstract int fare(int distance);
}

public class EnumEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("bus 요금 : " + Transportation.BUS.fare(100));
		System.out.println("train 요금 : " + Transportation.TRAIN.fare(200));
		
	}

}
