package ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 컬렉션 프레임워크(Collections Framework)
 * 
 * 데이터 집합을 저장하는 클래스들을 표준화한 설계.
 * 
 * 컬렉션 : 데이터 집합, 그룹
 * 프레임워크 : 표준화된 프로그래밍 방식
 * 
 * 핵심 인터페이스 : 
 * 		Collection : List, Set 의 기반.
 * 					컬렉션 클래스에 저장된 데이터를 읽고, 추가, 삭제 하는 등
 * 				컬렉션(데이터 집합)을 다루는데 가장 기본적인 메소드를 정의하고 있음.
 * 
 * 		List : 순서가 있는 데이터 집합. 중복 허용. 
 * 				ArrayList, LinkedList, Stack, Vector 등
 * 
 * 				LinkedList
 * 					class Node {
 * 						Node next; // 다음의 Node 를 가르키는 정보.
 * 									// 단방향 LinkedList 임을 알 수 있음.
 * 						Object obj;
 * 					}
 * 
 * 				ArrayList 와 LinkedList 차이점
 * 					- 접근시간(읽기) : ArrayList 가 빠름.
 * 					- 삭제 : LinkedList 가 빠름.
 * 
 * 
 * 				Stack
 * 					- LIFO(Last In First Out) 
 * 					- 단방향 구조(위에서 밑으로만)
 * 
 * 				Queue
 * 					- FIFO(First In First Out)
 * 					- 단방향 구조(위에서 밑으로만)
 * 
 * 				Deque(Double Ended Queue)
 * 					- 양방향 구조(위 아래로 가능)
 * 					
 * 
 * 				Iterator
 * 					컬레션 프레임워크에서 컬렉션에 저장된 데이터를 읽어오는 방법을 표준화.
 * 
 * 					종류 : Iterator, Enumeration, ListIterator
 * 					차이점 : Enumeration 은 Iterator 의 구버전.
 * 							ListIterator 는 Iterator 를 상속받아서 기능을 추가적으로 구현.
 * 
 * 							따라서, Enumeration 은 regacy 코드의 유지를 위해서 사용.
 * 							신규 개발에서는 ListIterator or Iterator 를 사용.
 * 
 * 					메소드 : hasNext(), next(), remove()
 * 							=> for 문을 사용하지 않고도 탐색이 가능.
 * 							=> 표준화된 개발이 가능. 재사용성, 코드의 일관성, 코드 품질
 * 
 * 
 * 				Comparator, Comparable : 컬렉션의 정렬과 관련된 기능.
 * 
 * 
 * 		Set : 순서를 유지하지 않음. 중복 허용하지 않음.
 * 				HashSet, TreeSet 등 
 * 
 * 
 * 		Map : 키(key)와 값(value)의 쌍으로 이루어진 데이터 집합.
 * 			순서 유지하지 않음. 키 중복 허용하지 않음. 값은 중복 허용.
 * 				HashMap, TreeMap, HashTable, Properties 등	
 * 
 * 
 * 
 * 
 * 
 */

public class CollectionsFWEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ArrayList
		ArrayList list1 = new ArrayList(5);
		list1.add(5);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		
		System.out.println("list1 : " + list1);
		
		// 정렬
		Collections.sort(list1);
		System.out.println("list1 : " + list1);
		
		//다른 데이터 유형 저장
		list1.add(3, "A");
		System.out.println("list1 : " + list1);
		
		Collections.shuffle(list1);
		System.out.println("list1 : " + list1);
		
		
		
		
		// LinkedList
		LinkedList ll = new LinkedList();
		
		// 탐색 속도 비교 대상
		ArrayList al = new ArrayList(100000);
		
		// list 에 데이터 저장
		add(ll);
		add(al);
		
		// 탐색 시간 확인
		System.out.println("LinkedList : " + access(ll) );
		System.out.println("ArrayList : " + access(al));
		
		
		
		//-------------------- Iterator 사용 -----------------------
		ArrayList list2 = new ArrayList();
		list2.add("1");
		list2.add("2");
		list2.add("3");
		
		Iterator it = list2.iterator();
		
		// 표준화된 데이터 탐색이 가능해짐.
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		// ListIterator : Iterator 을 개선. 양방향 탐색이 가능.
		ListIterator lit = list2.listIterator();
		
		// 순방향 탐색
		while(lit.hasNext()) {
			System.out.println(lit.next());
		}
		
		System.out.println();
		
		// 역방향 탐색
		while(lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
		
		
		//-------------------- Comparator, Comparable -----------------------
		// 기본형 타입
		// 우리한테 의미 있는 것은 값이 10.
		int a = 10;
		
		// 참조형 타입
		// 우리한테 의미 있는 것은 값이 10.
		// 랩퍼 클래스 : 기본형 int 객체로 관리하고 싶은 경우 제공되는 클래스
		Integer ii = new Integer(10);
		
		ii.compareTo(ii);
		
		// 정렬
		String[] strArr = {"cat", "Dog", "loin", "tiger"};
		
		// sort() 메소드의 기본 정렬은 오름차순임.
		// 내림차순으로 정렬하려는 경우
		// 1. Comparator interface 를 구현 클래스 작성.
		//    compare 메소드를 내림차순 되도록 재정의
		// 2. Arrays 에서 제공되는 sort() 중에서
		//	  Comparator 타입의 매개변수가 있는 메소드를 선택.
		// 3. 구현된 Comparator 클래스를 이용해서
		//	  sort() 메소드의 매개변수로 적용해서 사용.
		
		Arrays.sort(strArr);
		System.out.println("strArr = " + Arrays.toString(strArr));
		
		// 내림차순 정렬
		Arrays.sort(strArr, new Descending());
		System.out.println("strArr = " + Arrays.toString(strArr));
		
		
		
	}

	// list 에 데이터 저장.
	public static void add(List list) {
		for (int i=0; i<100000;i++) list.add(i+"");
	}
	
	// list 를 탐색.
	public static long access(List list) {
		long start = System.currentTimeMillis();
		
		// 시작 노드에서 마지막 노드까지 이동하면서 탐색
		for(int i=0; i<100000; i++) list.get(i);
		
		long end = System.currentTimeMillis();
		
		//탐색 시간(조회 시간)
		return end - start;
	}
	
}


// 역방향 정렬을 위한 클래스. Comparator interface 를 구현하면 됨.
class Descending implements Comparator {
	public int compare(Object o1, Object o2) {
		if ( o1 instanceof Comparable && o2 instanceof Comparable )	{
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			
			return c1.compareTo(o2) * -1;
		}
		
		return -1;
	}
}


