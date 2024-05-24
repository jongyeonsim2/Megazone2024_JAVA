package ch6;

/**
 * - 매개변수의 다형성
 *   쇼핑몰 시스템 구축, 상품정보, 회원
 * 
 *   상품 정보 : 기반 클래스, 카메라, 컴퓨터
 *   회원 정보 : 결제, 구매 메소드
 *             구매(상품), 구매(카메라), 구매(컴퓨터)
 *             
 *             구매(상품) => 메소드의 매개변수의 다형성
 *             
 *    현재는 JAVA 만 사용된 비즈니스 로직이 됨. => spring boot 에 소스의 일부.
 *    
 *    AWS에 SaaS(웹 애플리케이션)
 *    웹 애플리케이션(react, spring boot, mysql, jpa)
 *    
 *    
 */

public class OopEx4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 상품, 구매자 인스턴스 생성
		// 구매자가 상품을 구매
		// 구매 가능, 구매 불가능
		
		Buyer buyer = new Buyer();
		
		// 상품이 다르지만, 동일한 구매 메소드를 사용.
		// buy 매개변수에 상품의 기반 클래스인 Product3 타입으로 선언되어 있음.
		buyer.buy(new Camera());
		buyer.buy(new Computer());
		buyer.buy(new Camera());
		
		System.out.println(buyer.money);
		
		buyer.buy(new Computer());
		
		System.out.println(buyer.money);

		// 구매리스트를 조회 하고 싶음.
		// 현재 구매 후에는 소유할 수 없는 상태임.
		// 객체 배열을 활용.
		
		// 객체 배열의 단점. 구매할 수 있는 상품의 가지수가 제한됨.
		// 구매 개수에 대한 제한이 없도록 하기위한 방법 모색.
		
		// 동시접속자수가 증가를 대히만 서비스 운영 환경 구축 => 컨테이너, 클라우드
		

		
		
	}

}

// 상품정보에 대한 기반 클래스
class Product3 {
	int price;
	int bonusPoint;
	
	Product3(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}

// 상품 : 카메라
class Camera extends Product3 {
	Camera() {
		super(1000);
	}
	
	public String toString() {
		return "Camera";
	}
}

// 상품 : 컴퓨터
class Computer extends Product3 {
	Computer() {
		super(1000);
	}
	
	public String toString() {
		return "Computer";
	}
}

// 구매자(회원)
class Buyer {
	int money = 3000;
	int bonuxPoint = 0;
	
	// 구매 비즈니스 로직
	// 구현해보세요~~~~
	
	// 1. 매개변수 다형성 적용
	// 		구매할 상품의 가지수가 계속 늘어나는 것을 고려.
	// 2. 구매 가능한지를 확인. 금액을 확인.
	//    - 구매 불가, 구매 가능
	// 3. 구매한 경우 잔액 변경.
	// 4. 보너스 포인트 지급
	// 5. 구매(결제) 성공 메시지 출력
	void buy(Product3 p) {
		// 구매 가능 여부 체크
		if(this.money < p.price) {
			System.out.println("구매 가능한 금액이 아닙니다.");
			return;
		}
		
		this.money -= p.price;
		this.bonuxPoint += p.bonusPoint;
		System.out.println("상품 구매가 완료되었습니다.");
	}
	
	/*
	void buy(Camera product) {
	}

	void buy(Computer product) {	
	}
	*/

	
}

