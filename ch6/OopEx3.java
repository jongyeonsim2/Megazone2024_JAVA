package ch6;

/**
 * - 다형성(polymorphism : 폴리모피즘)
 *   
 *   다양한 형태를 가지고 있음. => 일반적인 의미.
 *   
 *   한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 함. => OOP에서의 의미.
 *   => 타입 변환 => 형 변환(casting)
 * 
 *   Tv t = new Tv();  // 기반 클래스
 *   TvVcr tvcr = new TvVcr();  // 파생 클래스
 *   TvCation tvca = new TvCation(); // Tv 로 부터 파생된 클래스임.
 *   
 *   Tv t = new TvVcr();  // 다형성, 인스턴스는 TvVcr 인데,
 *   					// 참조 변수의 타입은 Tv 인 기반 클래스 타입임.
 *   
 *   Tv t = new TvCation();
 *   
 *   => Tv 라는 하나의 타입으로 TvVcr, TvCation 의 인스턴스 타입으로 표현함.
 *   
 * - 다형성으로 표현된 클래스가 인스턴스가 되었을 때.
 * 
 *   Tv tv = new TvVcr(); // 메모리의 인스턴스는 TvVcr 임.
 *   					// 참조변수의 타입이 기반 클래스임
 *   					// 따라서, 기반 클래스의 범위 내에서 사용 가능. 
 *   					// 인스턴스 사용에 제한 있음.
 *   					// 
 *   					// 비록 인스턴스는 TvVcr 이지만,
 *   					// Tv의 멤버들만 사용 가능.
 *   
 *   					// 그래서, TvVcr 의 모든 것을 사용하려면, 
 *   					// down casting 임.
 *   
 *   TvVcr tvcr = new TvVcr(); // 메모리의 인스턴스는 TvVcr 임.
 *   					// 참조변수의 타입이 자기 자신.
 *   					// 따라서, 파생 클래스 자신의 범위내에서 사용 가능.
 *   					// 인스턴스 사용에 제한 없음.
 * 
 *   현재 까지 배운 내용에서의 다형성에 대한 장점.
 * 
 *   Tv tv = new Tv();
 *   Tv tv = new TvVcr();
 *   Tv tv = new TvCamera();
 *   Tv tv = new TvGame();
 *   Tv tv = new TvCdPlayer();
 *   
 *   다양한 타입의 인스턴스들을 하나의 타입으로 표현.
 *   Tv[] tvArr = new Tv[100];
 *   
 *   Tv[0] = new TvVcr();
 *   Tv[1] = new TvCamera();
 *   Tv[2] = new TvGame();
 *   Tv[3] = new TvCdPlayer();
 *   
 *   형변환(casting)
 *     1. up casting : 파생(자식) -> 기반(부모), 자동형변환
 *     				자바는 단일상속만 허용. 파생 입장에서 부모는 하나임으로 자동 형변환.
 *     2. down casting : 기반(부모) -> 파생(자식), 명시적 형변환
 *     				기반 입장에서는 파생이 경우에 따라서 여러개 일 수 있으므로,
 *     				down casting 대상이 누가 될 지 알 수 없으므로, 명시적 형변환
 *   
 *   
 * - instanceof 연산자
 *   메모리 상의 인스턴스 상태까지 고려해주는 것은 아님.
 *   그래서, 상속관계의 상태만 고려해주는 것임.
 *   
 *   참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보는 용도로 사용.
 *   
 *   
 * - 다형성의 활용과 instanceof 의 용도
 *   매개변수를 활용한 다형성 => 메소드의 매개변수가 다형성을 띄고 있다.
 *   		전달된 인스턴스의 참조변수의 타입에 따라 
 *   		해당 인스턴스의 멤버변수 사용시 범위를 알 수 있기 때문.
 *   
 *   반환타입을 활용한 다형성 => 메소드의 반환타입이 다형성을 띄고 있다.
 * 			메소드를 호출한 쪽에서 현재 참조변수가 누구의 인스턴스인지 확인이
 *          필요한 경우가 있기 때문.
 *          
 *   매개변수를 활용하는 메소드의 경우, 반환형이 있는 메소드 (void 메소드는 제외) 경우,
 *   오버로딩을 통해서 동일한 기능을 하는 메소드가 많아지면, 유지보수가 힘들어 짐으로
 *   기반 클래스 타입으로 매개변수와 반환형을 적용하면, 관리해야 할 메소드가 줄어듬으로
 *   유지보수가 간편해 질 수 있는 장점이 있음.
 *   
 * - 참조변수와 인스턴스의 연결
 * 
 * 
 * 
 * 
 * 
 */




public class OopEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car2 car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		
		// 다형성 고려한 코드
		car = fe;//인스턴스는 파생클래스인데, 참조변수 타입은 기반클래스임.
				// up casting, 자동 형변환
		car = (Car2)fe;
		
		// car 참조 변수의 인스턴스 사용 범위 고려
		//car.water(); // 파생 인스턴스의 멤버를 사용할 수 없음.
		
		fe2 = (FireEngine)car;// down casting, 명시적 형변환
		// runtime error 발생하지 않고, 정상 종료됨.
		// 메모리 상에는 FireEngine 의 인스턴스가 있음.
		// FireEngine 파생클래스는 기반 클래스인 Car2 로부터 상속된 상태임.
		// 메모리 상의 FireEngine 내부에는  Car2 가 있음.
		
		// 따라서, 메모리상에는 Car2 도 존재하고, FireEngine 도 존재하고 있는 상태임.
		// 따라서 up and down casting가 됨.
		
		
		fe2.water();
		
		//fe2 = car;
		
		//############### 다운 캐스팅시 고려할 사항
		// 업, 다운이 모두 다되는 경우가 있고, 아닌 경우가 있음.
		
		Car2 car2 = new Car2();
		Car car3 = null;
		FireEngine fe3 = null;
		
		car2.drive();
		// 
		//fe3 = (FireEngine)car2; // down casting
							// down casting 의 본질적은 목적은
							// 파생 클래스 인스턴스의 멤버들을 사용하기 위함.
		
		// 현재 메모리의 인스턴스는 Car2 만 존재하고 있음.
		// 그래서, 메모리에는 down casting 해서 사용할 FireEngine 이 없는 상태임.
		// 따라서, 메모리에 존재하지 않는 FireEngine 의 멤버를 사용하기 위해
		// 다운캐스팅 한다는 자체가 말이 안됨.
		
		// FireEngine 의 멤버를 사용하기 위해 시도(실행)해서, 실행하니깐
		// 메모리에 존재하지 않는다는 것이 확인이 되니, 실행 에러가 발생해서
		// 비정상 종료가 됨.
		
		/**
		 * 현재의 인스턴스는 Car2 임. FireEngine 가 아님.
		 * 메모리에 있는 인스턴스는 Car2 임으로
		 * FireEngine 로 다운 캐스팅 하더라고 Car2 만 존재하고 있으므로,
		 * FireEngine 의 멤버들을 사용할 수 없음.
		 * 
		 * 에러의 종류 : 문법 엔러, 실행(runtime) 에러
		 * 			문법적으로는 정상적인 것이지만, 실제 메모리상의 존재 인스턴스에
		 * 			위배되는 코드로 실행이 됨으로 runtime 에러가 발생하게 됨.
		 * 
		 * 다형성을 활용하는 코드 작성시, 반드시 메모리 상의 인스턴스 상태를 고려해서
		 * 코드를 작성해야 함.
		 * 
		 */
		
		
		//########### instanceof 연산자
		FireEngine fe4 = new FireEngine();
		
		// up casting 가능여부를 확인하는 코드
		if (fe4 instanceof FireEngine) {
			System.out.println("up casting - FireEngine instance");
			FireEngine fe5 = (FireEngine)fe4;
		}
		
		if (fe4 instanceof Car2) {
			System.out.println("up casting - Car2 instance");
			Car2 car4 = (Car2)fe4;
		}
		
		if (fe4 instanceof Object) {
			System.out.println("up casting - Object instance");
			Object obj = (Object)fe4;
		}
		
		
		Object fe5 = new FireEngine();
		
		// down casting 가 되는지 확인
		if (fe5 instanceof Object) {
			System.out.println("down casting - Object instance");
			Object obj = (Object)fe5;
		}
		
		if (fe5 instanceof Car2) {
			System.out.println("down casting - Car2 instance");
			Car2 obj = (Car2)fe5;
		}
		
		if (fe5 instanceof FireEngine) {
			System.out.println("down casting - FireEngine instance");
			FireEngine obj = (FireEngine)fe5;
		}
		
		if (fe5 instanceof Ambulance) {
			System.out.println("down casting - Ambulance instance");
			Ambulance obj = (Ambulance)fe5;
		}
		
		//############# 참조변수와 인스턴스의 연결 관련 1

		// casting 후 사용되는 멤버 변수와 메버 메소드를 확인.
		Parent3 p = new Child3();
		Child3 c = new Child3();
		
		// 오브라이드 된 상태에서 up casting 인 경우
		// 멤버 변수를 사용하는 경우. 참조 변수의 타입을 따라감.
		// 멤버 함수를 사용하는 경우. 인스턴스의 클래스 타입을 따라감.
		
		
		// 참조변수의 타입이 Parent3 인 경우
		// Child3 의 멤버변수 및 멤버메소드 사용
		// up casting 가 되었다고 가정. => 기반클래스의 멤버를 사용하려는 목적.
		System.out.println("p.x = " + p.x); // 목적 달성.		기반 멤버.
		p.method();							// 목적 달성 못함. 파생 멤버.
		
		// 참조변수의 타입이 Child3 인 경우
		// Child3 의 멤버변수 및 멤버메소드 사용
		System.out.println("c.x = " + c.x); // 파생 멤버
		c.method();							// 파생 멤버
		
		
		//############# 참조변수와 인스턴스의 연결 관련 2
		// 기반 클래스에만 멤버가 있는 경우. 파생 클래스에 멤버가 없는 경우.
		
		Parent4 p4 = new Child4();
		Child4 c4 = new Child4();
		
		System.out.println("p4.x = " + p4.x);
		p4.method();
		
		System.out.println("c4.x = " + c4.x);
		c4.method();
		
	}//end of main()

}

//참조변수와 인스턴스의 연결 관련 클래스
class Parent3 {
	int x = 100;
	
	void method() {
		System.out.println("Parent3:method()");
	}
}

class Child3 extends Parent3 {
	int x = 200;
	
	// 메소드 오버라이딩
	void method() {
		System.out.println("Child3:method()");
	}
}



class Parent4 {
	int x = 100;
	
	void method() {
		System.out.println("Parent4:method()");
	}
}

class Child4 extends Parent4 { }







//참조변수 형변환 관련 클래스
class Car2 {
	String color;
	int door;
	void drive() {
		System.out.println("운행중....");
	}
	void stop() {
		System.out.println("정지!!!");
	}
}

class FireEngine extends Car2 {
	void water() {
		System.out.println("화재 진압중...");
	}
}

class Ambulance extends Car2 {
	void siren() {
		System.err.println("사이렌중...");
	}
}















