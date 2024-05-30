package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
 * 
 * 				Queue
 * 					- FIFO(First In First Out)
 * 
 * 
 * 				Deque(Double Ended Queue)
 * 					
 * 					
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
