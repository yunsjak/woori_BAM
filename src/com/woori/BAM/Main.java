package com.woori.BAM;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in); // 최적화 => 자원 1번 사용

		int id = 1;

		while (true) {
			// System.out.printf("commend : ");
			// String cmd = sc.nextLine(); // cmd 변수 => 재사용
			// System.out.println("answer : "+ cmd);
			System.out.printf("commend : ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("exit")) {
				break;
			}
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해 주세요 : ");
				continue;
			}
			if (cmd.equals("article list")) {
				System.out.println("게시글이 없습니다");
			} else if (cmd.equals("article write")) {

				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim();
				System.out.println(id + "번글이 생성되었습니다");
				id++;

			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}
		sc.close();
		System.out.println("== 프로그램 종료 ==");
	}
}