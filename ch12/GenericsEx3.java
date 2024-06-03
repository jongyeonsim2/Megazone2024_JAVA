package ch12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
	// 와일드 카드를 적용. => 메소드의 중복 선언을 막기 위한 용도로 사용.
	// 메소드 중복의 해결 방법은 기반 타입으로 매개변수 타입이 되도록 하는 것임.
	// <? super T> : 하한 제한. T와 그 기반(조상)들만 가능. <= 사용된 와일드 카드
	// <? extends T> : 상한 제한. T 와 그 파생(자식)들만 가능. 
	// <?> : 제한이 없음. 모든 타입이 가능. <? extends Object>
 * 
 */

/**
 * 와일드 카드의 상한 제한 관련 코드
 * 
 * 
 */


public class GenericsEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// sort(List<Object> list, Comparator<? super Object> c)
		// 1. list, Comparator<Apple3>
		// 2. list, Comparator<Grape3>
		// 3. list, Comparator<Fruit3>
		Collections.sort(null, null);
		
	}

}

//Collections.sort() 의 두 번 매개변수로 사용될 Comparator 를 구현해야 함.
// Comparator<Apple3> 구현
class AppleComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

// Comparator<Grape3> 구현

// Comparator<Fruit3> 구현


class Fruit3 {
	String name;//과일 이름
	int weight; //과일 무게
	
	Fruit3(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String toString() {
		return name + "( " + weight +" )";
	}
}

class Apple3 extends Fruit3 {
	Apple3(String name, int weight) {
		super(name, weight);
	}
}

class Grape4 extends Fruit3 {
	public Grape4(String name, int weight) {
		super(name, weight);
	}
}

class FruitBox3<T extends Fruit3> extends Box3<T> {}

class Box3<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item); }
	T get(int i) { return list.get(i); }
	ArrayList<T> getList() { return list; }
	
	int size() { return list.size(); }
	public String toString() { return list.toString(); }
}




