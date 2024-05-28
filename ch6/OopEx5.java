package ch6;

/**
 * OOP의 4대 특성
 * - 캡슐화
 *   데이터를 외부에서 함부로 변경하지 못하도록 하기 위해서 접근을 제어하는 것.
 *   데이터 감추기(data hiding)
 *   
 *   외부에는 불필요한, 내부적으로만 사용되는, 부분을 감추기 위함.
 *   복잡성을 줄임. 
 *   
 *   문법적 : private
 *           데이터 사용 -> getter, setter, 필요한 비즈니스용 메소드
 *           
 *   		private 생성자 -> 인스턴스를 내부에서 생성하는 목적. -> singletone 디자인 패턴
 *   					-> getInstance()
 *   
 * - 상속
 *   기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것. 기반클래스, 파생클래스
 *   상속의 원칙은 단일 상속.( 단일 상속을 대신해서 확장 : 추상클래스, 인터페이스 )
 *   클래스 간의 관계에 대한 논리성을 고려. Is-A(상속), Has-A 관계(포함) -> 다중상속 같은 용도
 * 
 *   문법적 : extends ( 단일 상속에서 확장 : implements )
 *          생성자와 초기화 블록은 상속되지 않음. 멤버만 상속됨.
 * 
 * - 추상화
 *   클래스간의 공통점을 찾아내서 공통의 기반(조상)을 만드는 작업.
 *   추상클래스는 추상메소드가 존재하는 클래스.(추상메소드는 선언만된 상태. 몸통이 없는 상태.)
 *   
 *   추상화의 반대는 구체화. 상속을 통한 클래스 확장하는 작업.
 * 
 *   문법적 : extends ( 인스턴스로 사용 가능한 기반 클래스, 
 *   				  인스턴스로 사용 불가능한 기반 클래스 => 추상클래스 )
 * 
 * 
 * - 다형성(가장 중요함. 다형성을 이해하기 위해서는 캡슐화, 상속, 추상화 기반이 됨.)
 *   단어적인 의미는 여러 가지 형태를 가질 수 있는 능력 또는 특성.
 *   기반클래스 타입의 참조변수로 파생클래스의 인스턴스를 참조할 수 있도록 하는 것.
 *   => 인스턴스의 그룹핑이 가능해짐. => 관리가 편리해짐. ( 10개 메소드가 하나 의 메소드로 관리 )
 *   
 *   문법적 : 형변환 연산자, instanceof
 *   
 *   
 * 
 * 
 * 
 */


/**
 * ############################ interface ############################
 * 
 *   : 추상메소드, 다중 상속처럼 사용 가능, 다형성 => 논리적이지 않은 것도 묶을 수 있음.
 *   
 *   추상메소드 => 메소드 구현을 강제 시킬 수 있음. 신입사원 실수하지 못하도록 함.
 *   다중 상속 => 2 개 이상의 interface 를 사용. 따라서, 구현해야 하는 추상메소드도 2개.
 *   다형성 => Car, Airplane, Ship 의 공통점 : 이동체
 *   		  공격 기능 없지만, 공격 interface 를 만든다면,
 *            어떤 Airplane 공격 interface 를 구현하지 않고, => 여객기
 *            어떤 Airplane 공격 interface 를 구현하면,  => 전투기
 *            
 *            어떤 Ship 공격 interface 를 구현하지 않고, => 여객선
 *            어떤 Ship 공격 interface 를 구현하면,  => 함선
 *            
 *            인터페이스를 기준으로 관계없는 것들도 세분화해서 다형성을 적용할 수 있음.
 *            
 *            전투와 관련된 다형성
 *            전투와 관련되지 않은 다형성
 *            이동과 관련된 다형성
 *   
 * 
 *   인터페이스 예제 => 스타크래프트 캐릭터를 만듬. Marine, SCV, Tank, Dropship
 *   
 *   		클래스 간의 관계
 *   		Unit -> GroundUnit -> Marine, SCV, Tank
 *   			 -> AirUnit -> Dropship
 *   
 *   		추상클래스 -> 상속받아서 추상메소드를 오보라이딩(재정의) 해야만 인스턴스로 사용 가능.
 *   					논리적인 관계성이 있어야 함.
 *   		인터페이스 -> 클래스의 부족한면, 단일상속만 가능. 다중상속이 안됨.
 *   								관계성이 있는 것들끼리만 다형성을 적용할 수 있음.
 *   
 *   					다중상속처럼 사용가능. 관계가 없는 것끼리 다형성을 적용할 수 있음.
 * 
 * 			SCV 역할. - 수리, 자원 채취, 공격, 건축 등
 * 					-> SCV 의 수리 대상 : Tank, SCV, Dropship
 * 						수리 대상과 관련된 공통 부분을 interface 로 만들어서 사용.
 * 							=> 수리와 관련된 다형성을 적용 => 수리 메소드 하나로 처리 가능.
 * 			
 * 
 *   interface의 제약사항
 *      - 모든 멤버변수는 public static final 이어야 함. 생략할 수 없음.
 *      - 모든 메소드는 public abstract 이어야 함. 생략할 수 없음.
 *        단, static 메소드와 default 메소드는 예외.
 *        
 *   interface의 상속
 *      - 인터페이스는 인터페이스로부터만 상속을 받을 수 있음.
 *      - 다중 상속이 가능함.
 *      
 *   interface의 구현
 *      - 인터페이스의 추상 메소드를 구현하는 클래스에서 implements 를 사용해서 구현.
 *   
 * 
 */

/**
 * ################### 스타크래프트 Unit 구현 ######################
 * 
 * 클래스 간의 관계
 *   Unit -> GroundUnit -> Marine, SCV, Tank
 *   	  -> AirUnit -> Dropship
 *   
 *        -> Building -> Academy, Buncker, Barrack(공중), Factory(공중)
 * 
 * 
 *   1. SCV 클래스 구현
 *      - 수리(다형성 적용)
 *        대상 : SCV, Tank, Dropship
 *        
 *   2. Building 에서 공중을 띄우는 공통 능력을 interface 로 작성.
 *   3. Barrack, Factory 의 class 작성.
 * 
 */


public class OopEx5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 구체화된 Fighter 클래스 사용
		// 다형성이 적용이 되었는지 확인.
		// 클래스 간의 관계가 있는 다형성( Object, Unit )
		// Vector, 배열 에서의 Unit 관리 목적의 다형성 => 확인이 완료됨.
		
		// 클래스 간의 관계가 없는 다형성( Fightable, Attackable, Moveable )
		// => 메소드의 매개변수, 반환형 다형성 적용 가능 => 지금부터 확인 필요.
		
		Fighter f = new Fighter();
		
		if (f instanceof Fightable) {
			System.out.println("Fightable 타입임.");
		}
		
		if (f instanceof Moveable) {
			System.out.println("Moveable 타입임.");
		}

		if (f instanceof Attackable) {
			System.out.println("Attackable 타입임.");
		}

	}

}


// 클래스 작성
class Unit {
	int currentHP;//Unit의 에너지. 부족하면 수리 받아야 함.
	int x;			// 이동 좌표
	int y;			// 이동 좌표
}


// interface ( 이동, 공격 )
// Unit 의 이동 능력을 표현
interface Moveable {
	void move(int x, int y);
}

// Unit 의 공격 능력을 표현
interface Attackable {
	// 스타크래스트에서 모든 대상은 공격받을 수 있는 캐릭터임.
	// 모든 대상이 포함되도록 다형성 적용하면 됨. 관계도상의 최상위 기반 타입으로 하면 됨.
	void attack(Unit unit);
}

//interface의 상속
//Unit 의 이동 공격 능력을 표현
interface Fightable extends Moveable, Attackable { }

//-------------- 여기까지는 추상화 레벨임.( 기반 클래스, interface, 추상메소드 )

//-------------- 지금부터는 구체화 레벨.( 공격자 클래스 )
// class 의 상속, interface 의 구현
class Fighter extends Unit implements Fightable {

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack(Unit unit) {
		// TODO Auto-generated method stub
		
	}
}










