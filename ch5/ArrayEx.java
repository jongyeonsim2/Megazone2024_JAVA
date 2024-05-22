package ch5;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 배열
 * - 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
 *   기본형 타입을 저장하는 배열.
 *   다양한 타입을 저장하는 배열 => 객체 배열.( 상속, 다형성 )
 * - 배열 변수는 참조형. 배열의 첫 번째 요소의 주소값. 배열의 시작 위치 주소값.
 * - 각 요소값을 참조하기 위한 위치정보가 필요함.
 * - 배열의 위치(index)값은 0 부터 시작함. 위치값은 정수임.
 *   score[0], score[1], score[2].....
 * - 배열은 시작과 끝임 있음. => 배열의 크기 => 배열의 요소 개수
 *   문법 에러는 아니지만, 실행 에러 => indexOutOfBounds....
 * - 선언방법
 *   타입[] 배열변수명; <= 추천
 *   타입 배열변수명[];
 * - 배열 요소 초기화
 *   선언과 동시에 초기화 : 배열의 크기 고정
 *   선언 후 초기화 : 요소를 저장하는데 크기를 지정. 필요시 저장.
 * - 배열의 복사
 *   반복문을 활용 => 비용이 높다.
 *   System.arraycopy() 활용
 * - 배열의 활용
 *   총합과 평균
 *   최대값과 최소값
 *   섞기
 *   빈도수 구하기
 *   
 * - 배열의 기본값
 *   boolean : false
 *   char : null,
 *   byte, short, int : 0
 *   long : 0L
 *   float : 0.0f
 *   double : 0.0d
 *   참조형 : null. 참조형(주소) 배열 => 객체 배열.
 *   
 *   		null은 어떠한 객체도 가리키고 있지 않다는 것.
 *          => 요소 참조시 nullPointerException 이 발생함.
 *             따라서, 요소를 초기화 해야 함.
 *   
 *           클래스 작성한 코드 => 컴파일해서 바이트 코드 => jvm 바이트 코드 이용해서 실행 
 *           => 메모리에 클래스가 로딩이 됨. => 객체(메모리 주소를 확인)
 *           
 * - String 배열
 *	 String 클래스는 char 배열에 여러가지 편리한 기능(메소드)을 추가한 타입임.
 *   String 클래스에 저장된 내용은 읽을 수만 있고 변경할 수 없다.
 *  
 * - 다차원 배열
 *   1차원 배열 : 행으로만 구성됨.
 *   2차원 배열 : 행, 열로 구성됨.
 *   
 *   
 *   
 *   
 *   
 */

public class ArrayEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] score = {100, 90, 80, 70, 60};
		System.out.println(score[4]);
		// java.lang.ArrayIndexOutOfBoundsException 발생
		// System.out.println(score[5]);//위치정보를 직접 제어.
		
		
		// 배열 선언
		int[] score2;
		int score3[];
		
		int[] iArr1 = new int[10]; // 각 요소를 초기화하지 않은 상태.
		int[] iArr2 = {10, 20, 30, 40, 50}; 
		char[] cArr1 = {'a','b','c'};
		
		iArr1[0] = 10;
		System.out.println(iArr1[0]);
		
		iArr1[0] = 20;
		System.out.println(iArr1[0]);
		
		// 반복문을 활용한 전체 요소 초기화
		for (int i = 0; i < iArr1.length; i++) {
			iArr1[i] = i + 1;
		}
		
		for (int i = 0; i < iArr1.length; i++) {
			System.out.println(iArr1[i]);
		}
		
		// 반복문을 활용한 배열복사
		int[] arr2 = {1,2,3,4,5};//원본
		
		int[] tmp = new int[arr2.length];//복사본
		
		for(int i = 0; i < arr2.length; i++) {
			tmp[i] = arr2[i];
		}
		
		//원본, 복사본 모두 필요한 경우
		//복사본이 원본이 되어, 원본이 필요가 없게 되는 경우. => 가비지 컬렉트 대상.
		arr2 = tmp;//arr2는 기존의 배열의 시작주소가 없어지고,
					// 대신에 복사본의 매열의 시작주소가 저장이 됨으로
					//arr2는 가비지 컬레터 대상이 됨.
		
		// System.arraycopy() 
		// 매개변수 : 원본, 원본 시작위치, 복사본, 복사본 시작 위치, 원본 길이
		int[] arr3 = {6,7,8,9,10};//원본
		
		int[] tmp2 = new int[arr3.length];//복사본
		
		System.arraycopy(arr3, 0, tmp2, 0, arr3.length);
		
		for(int i = 0; i < tmp2.length; i++) {
			System.out.println(tmp2[i]);
		}
		
		//총합과 평균
		int sum = 0;
		float average = 0f;
		
		int[] score4 = {100, 90, 80, 70, 60};
		
		for (int i = 0; i < score4.length; i++)
		{
			sum += score4[i];
		}
		
		average = sum / (float)score4.length;
		
		System.out.println(sum + ", " + average);
		
		
		// 최대값, 최소값 구하기
		int max = score4[0];
		int min = score4[0];
		
		for(int i = 1; i < score4.length; i++)
		{
			if(score4[i] > max) {
				max = score4[i];
			} else if (score4[i] < min) {
				min = score4[i];
			}
		}
		
		System.out.println(max + ", " + min);
		
		// 섞기 - 난수 활용
		//System.out.println((int)Math.random() * score4.length);
		
		int[] tmpScore4 = new int[5];
		
		for (int i = 0; i < tmpScore4.length; i++) {
			int tmpIdx = (int)(Math.random() * score4.length);
			tmpScore4[i] = score4[tmpIdx];
		}
		
		System.out.println(Arrays.toString(tmpScore4));
		
		System.out.println(tmpScore4); //[I@35f983a6
		// tmpScore4 는 배열임. 참조형 변수. 주소값이 저장되어 있음.
		// 요소값의 변경을 확인하기 위해서 배열의 요소 하나씩 접근해서 확인.
		// 반복문이 필요함.
		// 가독성이 낮아짐. => 코드 품질 저하. => 자바에서 제공되는 API를 사용.
		for(int i = 0; i < tmp2.length; i++) {
			System.out.println(tmp2[i]);
		}//코드가 10번 반복.
		
		// 유지보수가 편해짐. => 코드 품질 향상. 협업에 도움.
		System.out.println(Arrays.toString(tmpScore4));
			
		//  빈도수 구하기
		// [7, 1, 7, 6, 7] 데이터 배열
		// 카운트 배열에서 데이터 배열의 요소값에 해당하는 위치에 1씩 증가.
		
		// 데이터 배열
		int[] numArr = new int[10];
		
		// 집계 배열
		int[] counter = new int[10];
		
		
		
		// 데이터 배열 초기화 - 난수 활용
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = (int)(Math.random() * 10);
			System.out.println(numArr[i]);
		}
		
	    // 집계
		for(int i = 0; i < numArr.length; i++)
		{
			// 데이터 배열의 요소값을 집계 배열의 인덱스로 사용.
			// 3, 4, 5, 3, 7, 8, 3 ....
			counter[numArr[i]]++;
			//counter[3]++
			//counter[4]++
			//counter[5]++
			//counter[3]++
			//counter[7]++
			//counter[8]++
			//counter[3]++
		}
		
		
		int[] counter2 = new int[10];
		System.out.println(Arrays.toString(counter2));
		
		
		// String 배열
		// 선언 후 그 다음에 초기화
		String[] name = new String[3];
		
		name[0] = "kim";
		name[1] = "park";
		name[2] = "hong";
		
		// 선언과 동시에 초기화
		String[] name2 = {"kim", "park", "hong"};
		
		System.out.println(Arrays.toString(name2));
		
		String[] name3 = new String[] {"kim", "park", "hong"};
		
		System.out.println(Arrays.toString(name3));
		
		for (String str : name3)
			System.out.println(str);
		
		// 참조형 변수, "KIM"이라는 char 배열을 가지고 있는 변수
		String str = "KIM"; //MIN 수정하고 싶다면...잘라내기, 대소문자 바꾸기
		// 문자열을 가공하는 기능이 있으면 좋겠다고 생각.
		// char 배열의 활용도를 높이기 위해서 만든 자료형이 String  임.
		System.out.println(str.toLowerCase());
		
		//String 은 값을 수정하지 못하고 읽을수만 있다.
		String str2 = "KIM2";
		
		// 주소 비교해서 같으면 같은(동일한) 변수임.
		if(str == str2) System.out.println("equal");
		
		if(str.equals(str2)) System.out.println("문자열 동일");

		// 2차원 배열 선언
		int[][] grade; // 추천
		int grade2[][];
		int[] grade3[];
		
		int[][] grade4 = new int[3][4];// 3행 4열
		// 첫 번째행은 요소갯수가 4개
		// 두 번째행도 요소갯수가 4개
		// 세 번째행도 요소갯수가 4개
		
		// 2행 3열을 선언과 동시에 초기화
		int[][] grade5 = 
				new int[][] {{1,2,3},{4,5,6}};
				
		int[][] grade6 = {{1,2,3},{4,5,6}};
		
		// 2행 3열의 요소 모두 조회
		for (int[] grade6tmp : grade6) { // 행처리, 1행, 2행
			for (int i : grade6tmp) { // 각 행의 요소 조회
				System.out.println(i);
			}
		}
		
		// 2행 3열 => 2명의 학생에 대한 3개의 교과목 점수를 관리
		// 첫 번째 => 홍길동 학생의 성적, 
		// 두 번째 => 이순신 학생의 성적
		int[][] grade7 = {{90,100,88}, {77,79,82}};
		
		// 가변 배열
		// 5명의 학생 성적에 대한 교과목 수는 제한하지 않음.
		int[][] grade8 = new int[5][];
		grade8[0] = new int[4]; // 첫 번째 학생의 교과목은 4개
		grade8[0] = new int[2]; // 두 번째 학생의 교과목은 2개
		grade8[0] = new int[3]; // 세 번째 학생의 교과목은 3개
		
		// 영어 단어 맞추기 게임
		// chair, 의자 => 1행
		// computer, 컴퓨터 => 2행
		// apple, 사과 => 3행
		// 3행 2열의 다차원배열
		
		String[][] words = {
				{"chair", "의자"},       // 00, 01
				{"computer", "컴퓨터"},  // 10, 11
				{"apple", "사과"}        // 20, 21
		};
		
		// 사용자에게 chair 를 보여줌.
		String inputStr = "의자";
		
		//System.out.println(words[0][1]);
		
		if(inputStr.equals(words[0][1])) System.out.println("정답");
		
		
		
	}

}
