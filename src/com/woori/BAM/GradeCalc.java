package com.woori.BAM;

import java.util.Scanner;

public class GradeCalc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int student_count = 0;

		System.out.print("총 학생 수 : "); // 총 몇 명의 학생인지 입력
		student_count = sc.nextInt();

		String[] names = new String[student_count];
		int[] scores = new int[student_count];
		String[] grades = new String[student_count];

		for (int i = 0; i < student_count; i++) { // 입력 받은 학생 수 만큼 반복하여 학생 이름과 점수 입력 받음
			System.out.printf("%d번째 학생 점수 : ", i + 1);
			scores[i] = sc.nextInt();
			sc.nextLine();

			System.out.printf("%d번째 학생 이름 : ", i + 1); 
			names[i] = sc.nextLine();
			

			switch (scores[i] / 10) { // 점수를 기준으로 등급 판단
			case 10:
			case 9:
				grades[i] = "A";
				break;
			case 8:
				grades[i] = "B";
				break;
			default:
				grades[i] = "c";
			}
		}
		// 모든 학생의 이름, 점수, 등급을 한 번에 출력
		System.out.printf("%d 명 학생의 점수 등급 \n", student_count);
		System.out.println("===========================================");
		for (int i = 0; i < student_count; i++) {
			System.out.printf("%d. 학생 이름 : %s, 점수 : %d, 등급 : %s \n", i + 1, names[i], scores[i], grades[i]);
		}
		System.out.println("===========================================");
		sc.close();
	}

}
