package ch6;

import java.util.Vector;

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
 *    (
 *    	linux,
 *    	network(osi 7layer, tcp/ip, http, https, 보안),
 *      docker(가상화, 컨테이너, 가상의 서버 - 컨테이너가 3개, 웹서버가 3개),
 *      쿠버네티스( 부하의 균형조절, 웹서버 300대 중에서 어떤 서버는 놀고, 어떤 서버는 부하가 걸리고 ),
 *      AWS(클라우드 환경 구축 - AWS skill builder)
 *      람다( serverless - 개발자가 작성한 코드가 실행. 개발자가 서버 관리 안해도 됨. )
 *      Native Cloud Application - MSA( MicroService Architecture )
 *    )
 *    
 *    웹 애플리케이션(
 *    	react:front-end, 
 *      spring boot:back-end <= 현재 공부하고 있는 java 소스가 들어감
 *      						응집도 높고, 결합도가 낮은 코드 작성, 
 *      mysql:db-sql, 
 *      jpa:객체기반의 db 관리-no sql, myBatis(sql) 도 사용하면 좋음.
 *    )
 *    
 * - 제어자
 *   접근 제어자    : public, protected, default, private
 *   	private : 같은 클래스 내에서만 접근
 *      default : 같은 패키지 내에서만 접근, 접근 제어자를 사용하지 않으면, default 임.
 *      protected : 같은 패키지 내에서, 그리고, 같은 패키지가 아니더라도
 *      		파생된 자식클래스에서 접근 가능.
 *      public : 접근 제한이 없음.
 *      
 *      public > protected > default > private
 *      
 *      접근 제어자의 사용 목적? => 캡슐화
 *         - 클래스 내의 데이터를 보호하기 위함. (information hiding)
 *         - 외부 노출을 하지 않도록 하기 위함. 복잡성을 제거.
 *           사용하는 쪽에서 보지 않아도 되는 것들을 보여주지 않도록 함.
 *      
 *      class 에서의 접근 제어자 : public, default
 *      method 에서의 접근 제어자 : public, protected, default, private
 *         생성자 에서의 접근 제어자 : private => singleton 디자인 패턴
 *             외부에서 생성자 접근을 할 수 없음. 클래스 내에서만 인스턴스를 생성.
 *            
 *      class Singleton {
 *      	private static Singlton s = new Singleton();
 *      
 *      	private Singleton() {  // private 생성자
 *      	}
 *      
 *      	public static Singleton getInstance() {
 *      		if (s == null) s = new Singleton();
 *      		return s;
 *      	}
 *      }
 *      
 *      
 *      
 *   
 *   접근 제어자 외 : static, final, abstract 등 
 *      static 
 *         멤버변수 - 모든 인스턴스에서 공통적으로 사용되는 클래스 변수가 됨.
 *         		  - 클래스 변수는 인스턴스를 생성하지 않고도 사용.
 *                  new 생성자() => 하지 않고, 클래스로 바로 접근 가능.
 *                - 클래스가 메모리에 로드될 때 생성.
 *                  Math.PI; => PI를 인스턴스를 생성하지 않고 사용하기 위해, 
 *                  			Math 를 메모리에 로드하게 됨.
 *                  
 *         멤버메소드 - 인스턴스를 생성하지 않고, 호출이 가능한 static 메소드가 됨.
 *         		   - static 메소드 내에서는 인스턴스 메버들을 사용할 수 없음.
 *         
 *         클래스 멤버들은 사용하기 편리하고, 속도가 빠름.(인스턴스 멤버보다)
 *   
 *   
 *      final
 *         변수에 사용되면 값을 수정할 수 없게 되어 상수가 됨.
 *         클래스에 사용되면 파생 클래스를 정의하지 못하게 됨.
 *         메소드에 사용되면 오버라이딩을 할 수 없게 됨.
 *         
 *         상수는 초기화 된 값으로만 사용.
 *         
 *            int max_value = 100;
 *            final int MAX_VALUE = 100; => 클래스간에 공유하는 값은 아님.
 *            							=> 인스턴스별로 값이 다를 수 있음.
 *            
 *            final static int MAX_VALUE = 100; => 클래스간에 공유하는 값.
 *         
 *            인스턴스별로 값을 모두 동일하게 초기화 하는 경우라면? =>  
 *               final static int MAX_VALUE = 100;
 *            
 *            인스턴스별로 상수를 다르게 초기화 해야 할 경우라면???
 *               final int MAX_VALUE = 100;
 *               생성자에서 초기화를 수행해야 함. 따라서, 인스턴스별로 다른 값을 가지게 됨.
 *               
 *            
 *         보통은 선언과 동시에 초기화. 
 *      
 *      
 *      
 *      abstract( 미완성 ) - 클래스, 메소드에 사용.
 *         클래스에 abstract 를 사용하면 미완성 클래스임을 나타냄. ( 추상 클래스 )
 *         미완성 클래스 는 추상 메소드가 있는 클래스.
 *      
 *         메소드에 abstract 를 사용하면 미완성 메소드임을 나타냄. ( 추상 메소드 )
 *         미완성 메소드는 선언부만 있고, 몸통은 없는 메소드.
 *         
 *         abstract class AbstractTest {  // 추상 클래스
 *         		abstract void move(); // 추상 메소드
 *         }
 *         
 *         추상 클래스의 존재 목적은 ?
 *         추상 클래스는 인스턴스 생성을 할 수 없음. 추상 클래스 자체로는 효용이 없음.
 *         추상 클래스를 구현하면 사용할 수 있음. => 상속.
 *         따라서, final 클래스가 아님으로 상속을 통해서 추상 메소드를 오버라이딩 해서
 *         사용 가능.
 *         
 *         상속 - 정상적인 클래스 : 자체적으로 인스턴스화가 가능.
 *               추상 클래스    : 자체적으로 인스턴스화가 불가능. 메소드를 구현해야 만.
 *               			메소드 구현을 강제 시키는 효과가 있음.
 *               
 *          1. 다형성으로 사용 가능.
 *             추상 클래스를 상속 받아서 추상 메소드를 구현했기 때문에,
 *             기반 클래스 타입으로 묶을 수 있음.
 *          2. 각 파생 클래스 별로 자기에 맞게 추상클래스를 재정의.
 *          
 *          abstract class Unit {
 *          	int x, y;
 *          	abstract void move(int x, int y); //추상메소드. 몸통없음.
 *          }
 *          
 *          // 파생 클래스들은 이동하는 기능이 있는 클래스들임.
 *          // Unit 을 상속받는게 논리적으로 위화감이 없음.
 *          // 이동 특성이 다음. (육지, 상공, 바다)위에서 이동함.
 *          // 파생 클래스들은 이동 기능이 필수인 클래스임.
 *          // 따라서, move() 의 구현을 강제시키는 목적임.
 *          class Car extends Unit {
 *          	void move(int x, int y) {
 *          		// 육로 이동 하도록 구현
 *          	}
 *          }
 *          
 *          class Airplane extends Unit {
 *          	void move(int x, int y) {
 *          		// 상공으로 이동 하도록 구현
 *          	}
 *          }
 *          
 *          class Ship extends Unit {
 *          	void move(int x, int y) {
 *          		// 해로 이동 하도록 구현
 *          	}
 *          }
 *          
 *          // 다형성 적용
 *          Unit[] movealbeUnit = new Unit[4];
 *          Unit[0] = new Car(); LPG
 *          Unit[1] = new Airplane(); 항공 휘발유
 *          Unit[2] = new Ship();  경유
 *          
 *          // 동시에 이동시키고 싶다면...
 *          for (Unit unit : Unit ) unit.move(100, 200);
 *          
 *          
 *          만약에, 다중 상속처럼 사용하지만, 멤버로 가지지 않고 사용하려면...
 *          + 메소드 구현을 강제하고 싶다면 => interface 
 *         
 *          interface : 다중 상속처럼 구현이 가능, 다형성 활용 => 관계없는 것을 그룹핑
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
		
		// 다형성을 적용한 객체(Product3) 배열.
		
		// 
		
		
		
		// FinalCard 사용
		FinalCard c = new FinalCard(13, "HEART");
		//c.number = 100;
		
		
	}// end of main()

}

// final 활용 - 인스턴스별 상수를 다르게 초기화
class FinalCard {
	// 카드 표면 무늬, 숫자
	// 카드 정보는 초기화 된 후 변경되면 안됨.
	// final 은 초기화하지 않으면 컴파일 에러가 발생.
	// 생성자에 초기화를 하면 됨.
	final int number;
	final String kind;
	
	// 상수 초기화를 위한 생성자.
	// 인스턴스 별로 상수를 초기화해서 사용할 수 있음.
	FinalCard(int num, String kind) {
		this.number = num;
		this.kind = kind;
	}
}



// final 활용
final class FinalTest {
	final int MAX_SIZE = 100;
	
	// 파생 클래스에서 기반 클래스의 메소드를
	// 재정의 하지 않고 따르게 하도록 하기 위해
	final void getMaxSize() {
		final int LV = 10;
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
	// 클래스 변수
	// 상품 구매 가능 최대 개수
	final static int MAX_ITME = 10;
	
	// 명시적 멤버변수 초기화
	int money = 3000;
	int bonuxPoint = 0;
	
	// 명시적 멤버변수 초기화
	Product3[] itemList = new Product3[MAX_ITME];
	
	// 저장 공간이 자동 증가되는 자료구조를 사용하면 됨.
	// java.util.Vector
	// 10 개의 인스턴스가 저장되는 공간이 만들어짐. 10개를 다 사용하면 자동 증가.
	// 편리한 사용 => add, remove, isEmpty, get, size()
	Vector item = new Vector();
	// 캡슐화를 적용하게 되면, 멤버변수는 외부에서 직접 접근을 할 수 없음.
	// getter, setter 를 통해서 접근. 현재는 필요 없음.
	// buy(), summary() : 구매목록, refund() : 반품 를 통해서 멤버변수에 접근하도록 함.
	
	// 비즈니스 로직
	// 구매 상품 목록에 대한 C(Create), U(Update), R(Read), D(Delete)
	//                   Vector.add, remove and add, get, remove
	
	// 반품, 구매목록 조회(remove, get)
	
	
	
	// 구매할 수 있는 상품수는 10개임.
	int i = 0; //현재 구매한 상품 수, 객체 배열의 위치정보
	
	
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
		
		// 구매 개수 제한
		// i < MAX_ITME
		// 8 < 10 : true => 구매 가능
		// 10 < 10 : false => 구매 불가
		if (!(i < MAX_ITME)) {
			return;
		}
		
		// 구매 객체 배열 처리
		this.money -= p.price;
		this.bonuxPoint += p.bonusPoint;
		
		// 구매한 상품 등록
		itemList[i++] = p;
		
		// 구매 상품 리스트(Vector) 등록
		item.add(p);
		
		System.out.println("상품 구매가 완료되었습니다.");
	}
	
	// 반품.
	void refund(Product3 p) { 
		
		if (item.remove(p)) {
			// 반품처리
			this.money += p.price;
			this.bonuxPoint -= p.bonusPoint;
			
			System.out.println("반품 처리가 완료되었습니다.");
		} else {
			System.out.println("삭제에러. 구매목록에 없는 제품입니다.");
		}
	}
	
	// 구매 상품 목록 출력.
	void summary() {
		int sum = 0;
		String itemList = "";
	
		// 1. 형변환( 유지보수성도 고려. )
		// Vector 의 상품 : Object
		// Product 의 상품 으로 down casting 해야 함.
		
		// Object -> Product -> Computer or Camera
		
		// 형변환이 일어날 때, 멤버변수 와 메소드 접근시 차이점.
		// 멤버변수 : 참조변수의 타입에 맞추어서 따라감.
		// 멤버메소드 : 인스턴스의 원래 타입으로 따라감.
		
		// 총 구매 금액( Product 형으로 ), 구매 목록 전체( Product 형으로 )
		
		
		
		// 2. 구매한 제품이 하나라도 있는지
		
		if (item.isEmpty()) {
			System.out.println("구매한 이력이 없습니다.");
			return;
		}
		
		for(int i = 0; i < item.size(); i++) {
			// 형변환( Object -> Product3 )
			Product3 p = (Product3)item.get(i);
			sum += p.price;
			
			// 제품 목록
			// computer, camera, notebook, => computer, camera, notebook
			// ,computer, camera, notebook => computer, camera, notebook
			itemList += (i==0) ? "" + p : ", " + p;
		}
		
		System.out.println("총 구매 금액은 " + sum + " 입니다.");
		System.out.println("구매 목록은 " + itemList + " 입니다.");
		
		
	}
	
	
	/*
	void buy(Camera product) {
	}

	void buy(Computer product) {	
	}
	*/

	
}

