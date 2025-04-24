package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in); // 최적화 => 자원 1번 사용

		int id = 1;
		List<Article> articles = new ArrayList<>();

		while (true) {
			// System.out.printf("commend : ");
			// String cmd = sc.nextLine(); // cmd 변수 => 재사용
			// System.out.println("answer : "+ cmd);
			System.out.printf("command : ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("exit")) {
				break;
			}
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해 주세요");
				continue;
			}
			if (cmd.equals("article list")) {

				System.out.println("게시글이 없습니다");
			} else if (cmd.equals("article write")) {

				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim();

				Article article = new Article(id,title,body); 
				// Article article = new Article(); 		  // article은 지역 변수
															  // 따라서 저장된 것은 아님
				// 최적화 작업 : 생성자 이용해서 초기화
//				article.id = id;							  					
//				article.title = title;											  
//				article.body = body;															
				
				// 진짜 저장은 아래 문장을 통해서 진행
				articles.add(article); // List 구조인 ArrayList 객체인 articles 저장
				
				// 최적화2 - 1줄로 위에 두 줄 기능 실행
//				articles.add(new Article(id,title,body));

				System.out.println(id + "번 글이 생성되었습니다");
				id++;

			} else if (cmd.equals("test")) {
				for (int i = 0; i < articles.size(); i++) {
					System.out.println(articles.get(i).id);
					System.out.println(articles.get(i).title);
					System.out.println(articles.get(i).body);
				}

			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}
		sc.close();
		System.out.println("== 프로그램 종료 ==");
	}
}

class Article {
	int id;
	String title;
	String body;
	
	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}

}