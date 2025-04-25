package com.woori.BAM;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in); // 최적화 => 자원 1번 사용

		int no = 1;
		List<Article> articles = new ArrayList<>();

		LocalDateTime now = LocalDateTime.now();
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		while (true) {
			System.out.printf("command : ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("exit")) {
				break;
			}
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해 주세요");
				continue;
			}
			if (cmd.equals("article write")) {

				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim();

				Article article = new Article(no, title, body);

				// 진짜 저장은 아래 문장을 통해서 진행
				articles.add(article); // List 구조인 ArrayList 객체인 articles 저장

				System.out.println(no + "번 글이 생성되었습니다");
				no++;

				// List 메서드 중 size() 이용 (Data 유무를 객체의 개수(크기)로 변환)
			} else if (cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 존재하지 않습니다.");
					continue;
				}
				// 배열 사용해서 get() 사용 ==> 객체를 리턴 받음
				System.out.println("번호 | 제목  | 내용");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i); // article 재사용 목적 : articles.get(i)의 기능을 저장할 변수
					System.out.printf(" %d   |  %s  |  %s \n", article.id, article.title, article.body);
				}

			} else if (cmd.startsWith("article detail ")) { // article detail로 시작하는지 확인
				String[] cmdBits = cmd.split(" ");

				Article check = null;

				int id = 0;

				try {
					id = Integer.parseInt(cmdBits[2]);

				} catch (NumberFormatException e) {
					System.out.println("정수만 입력해주세요");
					continue; // 다음 출력문 건너띄기 => while 실행
				} catch (Exception e) {
					System.err.println(e.getMessage()); // 그 외에 모든 exception 처리
				}
				
				for (Article article : articles) {
					if (article.id == id) { // 문자열을 정수형으로 변환
						check = article;
						break;
					}
				}
				if (check == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue; // 아래 코드 출력 시 nullPoint exception 발생 방지
				}
				System.out.println("번호 : " + check.id);
				System.out.println("날짜 : ~~~");
				System.out.printf("제목 : %s \n", check.title);
				System.out.printf("내용 : %s \n", check.body);

			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}
		sc.close();
		System.out.println("== 프로그램 종료 ==");
	}
}

class Article2 {
	int id;
	String title;
	String body;

	public Article2(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}

}