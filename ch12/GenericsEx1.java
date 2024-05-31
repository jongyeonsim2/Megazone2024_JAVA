package ch12;

import java.util.ArrayList;
import java.util.List;

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
 * - 지네릭 타입의 배열 생성을 할 수 없음.
 * - instanceOf 연산자, new 연산자에서 타입 변수 T 를 피연산자로 사용할 수 없음. 
 * 
 * 
 * 
 */

public class GenericsEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List arrList = new ArrayList();
		
		
		
	}

}
