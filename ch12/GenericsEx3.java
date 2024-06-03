package ch12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

/**
 * 지네릭 메소드
 * 메소드의 선언부에 지네릭 타입이 선언된 메소드임.
 * 
 * static 멤버에서는 지네릭을 사용하지 못함.
 * 지네릭 메소드에서는 지네릭 타입이 지역 변수처럼 메소드 내에서 지역적으로만 사용됨으로 
 * 사용 가능함.
 * 
 * Collections.sort();
 * 
 * public static <T> void sort(List<T> list) {  => 지네릭 메소드
        list.sort(null);
    }
 * 
 * 
 * 
 * 
 * 
 * public static <T extends Comparable<? super T>> void sort(List<T> list) {
        list.sort(null);
    }
    
    지네릭 부분의 와일드 카드를 제거해서 확인.
    
    public static <T extends Comparable> void sort(List<T> list) {
        list.sort(null);
    }
    
    지네릭 메소드의 지네릭 부분만 확인.
    
    <T extends Comparable>
    
    제한된 지네릭 클래스 => 관계성 적용 => Comparable 와의 관계를 적용 =>
 *  Comparable 인터페이스를 구현 
 *  => List<T>의 요소는 Comparable 인터페이스를 구현한 것이어야 함.
 * 
 */


public class GenericsEx3 {

	public static void main(String[] args) {
		
		Collections.sort(null);
		
		// TODO Auto-generated method stub

		// sort(List<Object> list, Comparator<? super Object> c)
		// 1. list, Comparator<Apple3>
		// 2. list, Comparator<Grape3>
		// 3. list, Comparator<Fruit3>
		
		// Java 의 API 인
		// Collections.sort() 의 두 번째 매개변수가 
		// 왜? 하한제한 와일드 카드가 적용되어 있는지를 생각해봐야 함.
		
		/**
		 * sort(List<Object> list, Comparator<T> c)
		 * 
		 * AppleComparator 구현이 필요.
		 * GrapeComparator 구현이 필요.
		 * FruitComparator 구현이 필요.
		 * 
		 * 
		 * sort(List<Object> list, Comparator<? super Object> c)
		 * 
		 * 따라서, 기반 타입의 Fruit 만 있으면 됨. => 다형성이 적용됨.
		 * FruitComparator 만 구현이 필요.
		 * 
		 * 
		 * 
		 */
		
		
		
		
		FruitBox3<Apple3> appleBox = new FruitBox3<Apple3>();
		FruitBox3<Grape4> grapeBox = new FruitBox3<Grape4>();
		
		appleBox.add(new Apple3("YellowApple", 200));
		appleBox.add(new Apple3("YellowApple", 100));
		appleBox.add(new Apple3("YellowApple", 300));
		
		grapeBox.add(new Grape4("GreenGrape", 500));
		grapeBox.add(new Grape4("GreenGrape", 300));
		grapeBox.add(new Grape4("GreenGrape", 200));
		
		Collections.sort(appleBox.getList(), new AppleComparator());
		Collections.sort(grapeBox.getList(), new GrapeComparator());
		
		System.out.println(appleBox);
		System.out.println(grapeBox);
		
		System.out.println();
		
		Collections.sort(appleBox.getList(), new FruitComparator());
		Collections.sort(grapeBox.getList(), new FruitComparator());
		
		System.out.println(appleBox);
		System.out.println(grapeBox);
		
		//Collections.sort(null, null);
		
	}

}

//Collections.sort() 의 두 번 매개변수로 사용될 Comparator 를 구현해야 함.
// Comparator<Apple3> 구현
class AppleComparator implements Comparator<Apple3> {
	@Override
	public int compare(Apple3 o1, Apple3 o2) {
		return o2.weight - o1.weight;
	}
}

// Comparator<Grape3> 구현
class GrapeComparator implements Comparator<Grape4> {
	@Override
	public int compare(Grape4 o1, Grape4 o2) {
		return o2.weight - o1.weight;
	}
}

// Comparator<Fruit3> 구현
class FruitComparator implements Comparator<Fruit3> {
	@Override
	public int compare(Fruit3 o1, Fruit3 o2) {
		return o2.weight - o1.weight;
	}
}

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




