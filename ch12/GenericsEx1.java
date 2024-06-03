package ch12;

import java.util.ArrayList;
import java.util.List;

/**
 * java.lang.UnsupportedOperationException
 * 
 * 이 클래스는 구현되지 않은 메소드나 메소드가 호출되지 않는 경우 라고 생각하면 됨.
 * 
 * 메소드를 직접 구현하거나 다른 메소드로 대체할 수 있는지 확인해서 예외를 해결.
 * 
 */



/**
 * 지네릭스( Generics )
 * 
 * 다양한 타입의 객체들을 다루는 메소드나 컬렉션 클래스에 컴파일 시의 타입 체크를 해주는 기능.
 * 
 * ArrayList
 * 
 * - 꺼집어 낼 때
 *   down casting 이 되는지 안되는지가 고려사항. 
 *   cating 전에 타입체크가 필요.(instanceOf 연산자)
 *    
 * - 저장 될 때
 *   원하지 않는 객체가 포함되지는 않을까 하는 고려사항.
 *   
 * 상기의 고려사항을 해결하면 Collection 을 사용하는데 부담이 없어짐. => 지네릭스
 * 
 * 지네릭스의 장점
 * - 타입 안정성을 제공.
 * - 타입체크와 형변환을 생략할 수 있음. => 코드가 심플해짐.
 * 
 * 지네릭의 사용한 다형성을 사용할 수 있으면 좀 더 유연한 코드 작성이 가능해짐.
 * 
 * 
 * class Box {
 *  	Object item;
 * 		
 * 		void setItem(Object item){
 * 			this.item = this;
 * 		}
 * 		
 * 		Object getItme() { return item; }
 * }
 * 
 * class Box<T> {
 *  	T item;
 * 		
 * 		void setItem(T item){
 * 			this.item = this;
 * 		}
 * 		
 * 		T getItme() { return item; }
 * }
 * 
 * 용어 정리
 * - Box<T> : 지네릭 클래스
 * - T		: 타입(Type) 변수
 * - Box	: 원시 타입
 * 
 * 
 * 인스턴스 생성
 * Box<T> b = new Box<T>();
 * 
 * Box<String> b = new Box<String>();
 * - String : 대입된 타입
 * - Box<String> : 지네릭 타입의 클래스를 호출
 * 
 * Box<Integer> b = new Box<Integer>();
 * 
 * 
 * 지네릭의 사용 제한
 * - static 멤버에 타입 변수 T 를 사용할 수 없음.
 *   static 멤버 는 인스턴스 멤버가 아님. => 인스턴스를 생성하지 않아도 사용 가능.
 *   하지만, 타입 변수 T 는 인스턴스임. 컴파일 시점에 타입이 지정됨으로 
 *   인스턴스 변수로 간주됨.
 *   
 *   class Box<T> {
 *   	//class 멤버
 *   	static T item; //에러
 *   }
 *   
 * - 지네릭 타입의 배열 생성을 할 수 없음.
 * 	 T[] tmpArr = new T[100]; //배열 생성 할 수 없음.
 * 
 * - instanceOf 연산자, new 연산자에서 타입 변수 T 를 피연산자로 사용할 수 없음. 
 * 
 * 
 * 
 * 지네릭스란?
 * 인스턴스별로 원하는 타입을 지정해서 사용하니까,
 * 지네릭스는 인스턴스 별로 다른 타입이 되도록 만들려고 하는 자바의 기능임.
 * 
 */

public class GenericsEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//List arrList = new ArrayList();
		
		// Box class
		
		// Box 에 담을 수 있는 타입 :
		// Fruit - Apple
		// Fruit - Grape
		
		// Box 에 담을 수 있는 타입 지정 : Fruit Box, Apple Box, Grape Box
		// - Fruit Box 에 담을 수 있는 대상 : Fruit, Apple, Grape
		// - Apple Box 에 담을 수 있는 대상 : Apple
		// - Grape Box 에 담을 수 있는 대상 : Grape
		
		// 과일 전용 박스
		Box<Fruit> fruitBox = new Box<Fruit>();
		
		// 사과 전용
		Box<Apple> appleBox = new Box<Apple>();
		
		// Grape 전용
		Box<Grape> grapeBox = new Box<Grape>();
		
		// Toy 전용
		Box<Toy> toyBox = new Box<Toy>();
		
		// 원하지 않는 타입이 저장되지 않도록 타입체크를 해서 알려줌.
		//Box<Fruit> fruitBox2 = new Box<Apple>();
		//Box<Toy> toyBox2 = new Box<Apple>();
		
		// add() Fruit 타입으로 다형성 매개 변수로 적용이됨.
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		// 매개변수의 타입이 Fruit임. Toy class 와 전혀 관계가 없음.
		//fruitBox.add(new Toy());
		
		appleBox.add(new Apple());
		//appleBox.add(new Grape());
		//appleBox.add(new Fruit());
		//appleBox.add(new Toy());
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		
		
		
		
	}

}

// Box class => 지네릭 클래스
class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item); }
	T get(int i) { return list.get(i); }
	
	int size() { return list.size(); }
	public String toString() { return list.toString(); }
}

// 과일 클래스들
class Fruit { public String toString() { return "Fruit"; } }

class Apple extends Fruit { public String toString() { return "Apple"; } }
class Grape extends Fruit { public String toString() { return "Grape"; } }

class Toy { public String toString() { return "Toy"; } }



