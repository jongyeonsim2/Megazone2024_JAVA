package ch6;

/**
 * 
 * ################# 본격적인 OOP ###########################
 * 
 * - 생성자
 *   인스턴스가 생성될 때 호출되는 '인스턴스 초기화 메소드'임.
 *   인스턴스의 초기화 작업에 주로 사용됨.
 *   인스턴스 생성 시 실행되어야 할 작업을 위해서도 사용됨.
 *   
 *   특징 : 구조가 메소드와 유사. 반환값이 없음.( void 사용하지 않음. ) 
 *   
 *   작성 : 생성자의 이름이 클래스 이름과 동일해야 함.
 *   
 *   생성자를 통한 인스턴스 생성.
 *   MyMath mm = new MyMath();  // 현재의 생성자는 코드에 없음.
 *   							// 컴파일러가 기본적으로 제공.
 *   
 *   0. 클래스 변수 초기화 블럭이 수행.
 *   
 *   1. 연산자 new에 의해서 메모리에 MyMath 클래스의 인스턴스가 생성됨.
 *      메모리의 빈공간에 MyMath 클래스를 적재할 곳을 마련. 메모리에 자리를 잡음.
 *      
 *      인스턴스 초기화 블럭이 있다면 수행됨. 
 *      
 *   2. 자리만 잡은 인스턴스의 초기화 작업을 수행하기 위해서
 *      MyMath() 가 호출이 됨.
 *      
 *   3. 생성된 MyMath 인스턴스의 주소가 반환이 되어 
 *      참조변수 mm에 저장됨.
 *      
 *   4. mm 참조 변수를 사용해서 인스턴스에 접근해서 사용.
 *   
 * - 기본 생성자(default constructor)
 *   
 *   컴파일 시 소스파일에 생성자가 하나도 정의가 되지 않은 경우,
 *   컴파일러가 제공함.
 *   
 * - 매개 변수가 있는 생성자
 *   인스턴스마다 각기 다른 값으로 초기화해야 하는 경우 사용.
 *   오버로딩도 적용 가능.
 *   
 *   인스턴스 변수 초기화(생성자 사용 전)
 *   d1.value = 100;
 *   d2.value = 200;
 *   d3.value = 300;
 *   d4.value = 400;
 *   d5.value = 500;
 *   
 *   
 *   인스턴스 변수 초기화(생성자 사용 후)
 *   Data1(100,200,300,400,500);
 *   
 * - 생성자에서 다른 생성자 호출.
 *   클래스 내에 여러개의 생성자가 있는 경우.
 *   
 * - 생성자를 이용한 인스턴스의 복사
 *   현재 사용하고 있는 인스턴스와 같은 상태를 갖는 인스턴스를 하나
 *   더 만들고자 할 경우. 
 *   => 상태가 동일함. 고유정보(주민번호)가 동일하다는 의미는 아님.
 * 
 *   생성자의 매개변수를 해당 클래스의 참조변수로 매개변수를 받으면 구현이 가능.
 *   
 * - 변수의 초기화
 *   멤버변수의 초기화는 기본값으로 초기화됨.
 *   지역변수는 반드시 초기화가 필수임.
 *   
 * - 멤버변수의 초기화 방법
 *   1. 명시적 초기화
 *      class car {
 *      	int doorType = 4;//기본형
 *      
 *      	DoorType dt = new DoorType(); //참조형
 *      }
 *   
 *   	참조변수.멤버변수 = 100;
 *   2. 생성자
 *   3. 초기화 블록
 *      - 인스턴스 변수 초기화 블록 : 인스턴스 변수가 대상.				
 *      - 클래스(static) 변수 초기화 블록 : 클래스 변수가 대상
 *      
 *      - 동작
 *        클래스가 메모리에 처음 로딩될 때 한 번만 수행되며,
 *        인스턴스 초기화 블럭은 생성자와 같이 인스턴스를 생성할 때마다 수행됨.
 *        인스턴스 초기화 블럭은 생성자 보다 먼서 초기화 블럭이 수행됨.
 *   
 * - 멤버변수의 초기화 시점
 *   클래스 변수 : 클래스가 처음 로딩될 때 단 한번 초기화
 *   인스턴스 변수 : 인스턴스가 생성될 때 마다 각 인스턴스별로 초기화 
 *   
 * - 멤버변수의 초기화 우선순위
 *   클래스 변수 : 기본값 -> 명시적 초기화 -> 클래스 초기화 블럭
 *   인스턴스 변수 : 기본값 -> 명시적 초기화 -> 인스턴스 초기화 블럭 -> 생성자
 * 
 * ################# 클래스 간의 관계 ###########################
 * 
 * - 상속
 *   조상 클래스 : 부모 클래스, 상위 클래스, 기반 클래스
 *   자식 클래스 : 자손 클래스, 하위 클래스, 파생된 클래스
 *   
 * - 장점
 *   상속을 통하면 보다 적은 양의 코드로 새로운 클래스를 작성.
 *   코드의 추가 및 변경이 매우 용이해짐.
 *   
 * - 단점
 *   강결합의 가능성이 있을 수 있음.
 *   
 * - 관계
 *   논리적으로 합당한 관계
 *   
 *   상속관계 : is-a 관계. ~은 ~이다.
 *   	사람, 학생. 학생은 사람이다. => 학생 extends 사람
 *      권총, 경찰. 경찰은 권총을 가지고 있다. => 논리적 성립 불가
 *   포함관계 : has-a 관계. ~은 ~ 가지고 있다.
 *      사람, 학생. 학생은 사람을 가지고 있다.
 *      권총, 경찰. 경찰은 권총을 가지고 있다. => 논리적 성립 가능 => 멤버변수 가능성
 *   
 * - 문법적 관계
 *   extends
 * 
 */

public class OopEx2 {
	
	static int staticVar = 0;
	
	// 클래스 변수 초기화 블럭
	static {
		System.out.println("staticVar(block()) = " + staticVar);
		System.out.println("클래스 변수 초기화 블럭 호출");
	}
	
	// 인스턴스 변수 초기화 블럭
	{
		System.out.println("인스턴스 변수 초기화 블럭 호출");
	}
	
	// 생성자
	public OopEx2() {
		System.out.println("생성자 호출");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("staticVar(main()) = " + staticVar);
		
		// Data1, Data2 인스턴스 생성
		Data1 d1 = new Data1();//기본 생성자
		
		System.out.println("d1.value = " + d1.value);
		
		Data2 d2 = new Data2();//Data2 클래스에는 매개변수가 있는 생성자가 존재.
							//컴파일러가 기본 생성자를 제공하지 않음.
		
		System.out.println("d2.value = " + d2.value);
		
		Data2 d3 = new Data2(777);
		System.out.println("d3.value = " + d3.value);
		
		
		// 생성자를 이용한 인스턴스의 복사
		Car c1 = new Car();
		System.out.println(c1.color);
		
		Car c2 = new Car(c1);
		System.out.println(c2.color);
		
		
		// 초기화 블럭 및 생성자 진행 순서 확인
		OopEx2 ope2 = new OopEx2();
		
		// Product class 사용.
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		// 포커카드 게임
		Deck d = new Deck(); // 52장의 포커 카드 준비 완료.
		PockerCard c = d.pick();
		System.out.println(c.toString());
		
		c = d.pick(1);
		System.out.println(c.toString());
		
		d.shuffle();
		c = d.pick(1);
		System.out.println(c.toString());
		
		
	}//end of main()

}


// 포커카드
class PockerCard {
	// 카드의 무늬 수
	static final int KIND_MAX = 4;
	// 카드의 무늬 별 총 수량
	static final int NUM_MAX = 13;
	
	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	
	// 카드별 무늬 및 숫자
	int kind;
	int number;
	
	PockerCard() {
		this(SPADE, 13);
	}
	
	PockerCard(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	// 현재 인스턴스 카드 한 장의 정보를 출력
	public String toString() {
		String[] kinds = {"","CLOVER","HEART","DIAMOND","SPADE"};
		String numbers = "0123456789XJQK";

		return "kind : " + kinds[this.kind] +
				", number : " + numbers.charAt(this.number);
	}
}

// 포커카드 한 세트
// 포커카드 한 벌은 52장의 포커 카드를 가지고 있다. (포함관계 => 멤버변수 => 객체배열)
class Deck {
	// 클래스변수
	final int CARD_NUM = 52;
	
	// 52장의 포커카드 인스턴스 변수
	PockerCard cardArr[] = new PockerCard[CARD_NUM];
	
	// 구현 대상!!!!!!
	// 생성자, 52장의 포커카드 인스턴스를 생성, 객체배열에 저장.
	Deck () {
		// 무늬 4개, 각 13장 => 중첩 반복문 => cardArr[] 저장.
		
		// 배열의 인덱스 변수
		int i = 0;
		
		// outter for : 무늬 담당 , inner for : 무늬별 카드 숫자 담당
		for(int k=PockerCard.KIND_MAX; k > 0; k--)// 4, 3, 2, 1
			for(int n=0; n<PockerCard.NUM_MAX; n++)
				cardArr[i++] = new PockerCard(k, n);
	}
	
	
	// 카드 뽑기 오버로딩, 인스턴스 메소드
	PockerCard pick(int idx) {
		return cardArr[idx];
	}
	
	// 구현 대상!!!!!!
	PockerCard pick() {
		// 난수를 이용해서 임의의 카드를 뽑을 수 있도록 배열의 위치정보 생성.
		int idx = 0;
		idx = (int)(Math.random() * CARD_NUM); // 0.0 ~ 1.0 => 0 ~ 52
						// 1.0 * 52 = 52
		return pick(idx);
	}
	
	// 구현 대상!!!!!!
	// 카드 섞기, 인스턴스 메소드
	void shuffle() {
		// 난수를 이용해서 임의의 카드를 뽑을 수 있도록 배열의 위치정보 생성.
		for(int i =0; i < cardArr.length; i++) 
		{
			int idx = (int)(Math.random() * CARD_NUM);
			
			PockerCard tmp = cardArr[i];
			cardArr[i] = cardArr[idx];
			cardArr[idx] = tmp;
		}
	}
	
}



// 상속 관련 클래스
// Parent, Child 는 is-a 관계 => extends
// Parent, Child 는 직접 상속 관계
class Parent {
	int age;
}

class Child1 extends Parent {}
class Child2 extends Parent {}

// Parent 기준으로는 간접 상속관계
// Child1 기준으로는 직접 상속관계
class GrandChild extends Child1 {}


// 포함 관련 클래스
// Pistol, Police 는 has-a 관계 => Pistol 은 Police 의 멤버변수.
class Pistol {}
class Police {
	Pistol p = new Pistol();
}

class Point {
	int x;
	int y;
}

class Circle {
	Point c = new Point();
	int r;
}

class Triangle {
	Point[] p = new Point[3];
}



// 클래스 변수를 이용한 인스턴스 변수 초기화
class Product {
	static int count = 0;
	int serialNo;  // 제품 시리얼 번호(식별자)
	
	//인스턴스 초기화 블럭
	{
		++count;
		this.serialNo = count;
	}
	
	public Product() {
		
		System.out.println("serialNO = " + this.serialNo);
	}
}

// 생성자가 없는 클래스
class Data1 {
	int value;
}

// 자동차 클래스
class Car {
	String color;
	String gearType;
	int door;
	int count;
	int serialNo;
	
	// 인스턴스 변수 초기화 블록
	// 모든 생성자에서 공통으로 수행되어야 하는 문장들이 있다면,
	// 하나의 블럭에서 관리하면, 가독성, 유지보수성이 높아짐. => 코드 중복 제거.
	{
		this.count++;
		this.serialNo = this.count;
	}
	
	// 클래스 변수 초기화 블록
	static 
	{
		int tireType = 4;
	}
	
	// 기본 생성자
	Car() {
		this("white", "auto", 3);
//		this.count++;
//		this.serialNo = this.count;
	}
	
	// 매개변수 한 개 생성자, 오버로딩됨.
	Car(String color) {
		this(color, "auto", 5);
//		this.count++;
//		this.serialNo = this.count;
	}
	
	// 매개변수 세 개 생성자, 오버로딩됨.
	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
		
//		this.count++;
//		this.serialNo = this.count;
	}
	
	// 자기자신 타입의 매개변수인 생성자 => 인스턴스 변수 초기화용
	Car(Car c){
		this.color = c.color;
		this.gearType = c.gearType;
		this.door = c.door;
		
//		this.count++;
//		this.serialNo = this.count;
	}
}


// 생성자가 있는 클래스
class Data2 {
	int value;
	
	// 기본 생성자.
	// 클래스에서 생성자가 하나도 없으면, 컴파일러가 제공해주지만,
	// 클래스에 다른 생성자가 하나라고 있으면, 컴파일러가 기본 생성자를 제공하지 않음.
	// 따라서, 기본 생성자를 사용하려면 명시적으로 추가하면 됨.
	Data2() {
		this(50);	// 첫 줄이고, 생성자 이름 대신에 this() 를 사용했기 때문.
		//Data2(50);  => 생성자 이름으로 생성자내에서 호출 못함.
		value = 100;
		//Data2(200);  => 생성자 이름으로 생성자내에서 호출 못함.
		//this(200); => 생성자의 사용 목적은 초기화임으로 
					// 반드시 첫 줄에서 사용.
	}
	
	// 매개변수가 있는 생성자
	Data2(int x) {
		value = x;
	}
	
	// 생성자도 함수의 한 형태이므로, 오버로딩이 됨.
	Data2(long x) {
		value = (int)x;
	}
}







