package com.woori.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.woori.BAM.dto.Article;
import com.woori.BAM.util.Util;


public class Main {
	
	static List<Article> articles;
	static int no;
	
	
	// 시작하자마자 초기화, 관례 or 가독성
	static {
		articles = new ArrayList<>();
		no = 1;
	}
	
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		Scanner sc = new Scanner(System.in); // 최적화 => 자원 1번 사용

		makeTestData();

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

				// 회원가입, 게시글 수정 => 공통 모듈로 이용 => 메서드 작성

				Article article = new Article(no, title, body, Util.getDateStr(), 0);

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
				System.out.println("번호  |  제목   |  내용   |  날짜                   | 조회수");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i); // article 재사용 목적 : articles.get(i)의 기능을 저장할 변수
					System.out.printf(" %d    |  %s  |  %s  |   %s   |  %d \n", article.getId(), article.getTitle(),
							article.getBody(), article.getDate(), article.getViewCount());
				}

			} else if (cmd.startsWith("article detail ")) { // article detail로 시작하는지 확인

				String[] cmdBits = cmd.split(" ");

				Article check = null;

				int id = 0;

				try {
					id = Integer.parseInt(cmdBits[2]);

				} catch (NumberFormatException e) {
					System.out.println("정수가 아닙니다. 다시 입력해주세요");
					continue; // 다음 출력문 건너띄기 => while 실행
				} catch (Exception e) {
					System.err.println(e.getMessage()); // 그 외에 모든 exception 처리
				}

				for (Article article : articles) {
					if (article.getId() == id) { // 문자열을 정수형으로 변환
						check = article;
						break;
					}
				}
				if (check == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue; // 아래 코드 출력 시 nullPoint exception 발생 방지
				}

				check.incViewCount(); // 위에 null 검증을 통과 했으므로 조회수를 1 증가

				System.out.println("번호 : " + check.getId());
				System.out.println("날짜 : " + check.getDate());
				System.out.printf("제목 : %s \n", check.getTitle());
				System.out.printf("내용 : %s \n", check.getBody());
				System.out.println("조회수 : " + check.getViewCount());

			} else if (cmd.startsWith("article delete ")) { // article detail로 시작하는지 확인
				String[] cmdBits = cmd.split(" ");

				Article check = null;

				int id = 0;

				try {
					id = Integer.parseInt(cmdBits[2]);

				} catch (NumberFormatException e) {
					System.out.println("정수가 아닙니다. 다시 입력해주세요");
					continue; // 다음 출력문 건너띄기 => while 실행
				} catch (Exception e) {
					System.err.println(e.getMessage()); // 그 외에 모든 exception 처리
				}

				// 향상된 for문은 인덱스 사용x, 일반 for문 사용 -> 수정
				for (Article article : articles) {
					if (article.getId() == id) { // 문자열을 정수형으로 변환
						check = article;
						break;
					}
				}

//				//향상된 for문 이용 + foundIndex 이용 
//			    int foundIndex = -1 ; // null과 같은 의미로 -1 로 초기화 (존재하지 않는 index 의미)
//
//			    int indexId = 0;
//			    
//			    for(Article article : articles) {
//			    	if (article.id == id) {
//			    		foundIndex = indexId;
//			    		foundArticle = article; // 누락된 명령어, null 검증 위해 필요
//			    		break;
//			    	}
//			    	indexId++;
//			    }

				// 일반 for문 이용 + foundIndx 이용
//			    int foundIndex = -1 ; // null과 같은 의미로 -1 로 초기화 (존재하지 않는 index 의미)
//				
//				for (int i = 0; i < articles.size(); i++) {
//					Article article =articles.get(i);
//					if (article.id == id) {
//						foundArticle = article;  // 누락된 명령어, null 검증 위해 필요
//						foundIndex = i;
//						break;
//					}
//				}

				if (check == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue; // 아래 코드 출력 시 nullPoint exception 발생 방지
				}

				articles.remove(check);
//				articles.remove(foundIndex);
				System.out.println(id + "번 게시글이 삭제 되었습니다.");

			} else if (cmd.startsWith("article modify ")) { // article detail로 시작하는지 확인
				String[] cmdBits = cmd.split(" ");

				Article check = null;

				int id = 0;

				try {
					id = Integer.parseInt(cmdBits[2]);

				} catch (NumberFormatException e) {
					System.out.println("정수가 아닙니다. 다시 입력해주세요");
					continue; // 다음 출력문 건너띄기 => while 실행
				} catch (Exception e) {
					System.err.println(e.getMessage()); // 그 외에 모든 exception 처리
				}

				for (Article article : articles) {
					if (article.getId() == id) { // 문자열을 정수형으로 변환
						check = article; // article 주소 > check 복사
						break;
					}
				}
				if (check == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue; // 아래 코드 출력 시 nullPoint exception 발생 방지
				}

				System.out.printf("수정할 제목 : ");
				String head = sc.nextLine().trim();

				System.out.printf("수정할 내용 : ");
				String text = sc.nextLine().trim();

				check.setTitle(head); // 수정된 값을 객체에 저장
				check.setBody(text);

				System.out.println(id + "번 게시글이 수정 되었습니다");

			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
		}
		sc.close();
		System.out.println("== 프로그램 종료 ==");
	}

	private static void makeTestData() {
		// 방법2) 고정 게시글 3개 => 10개 업그레이드 => 반복문(for문) 활용 => 시작하자마자 실행
		for (int i = 1; i <= 5; i++) {
			articles.add(new Article(no++, "제목" + i, "내용" + i, Util.getDateStr(), 10 * i));
		}

		// 방법1) 2줄을 1줄로 최소화
//		articles.add(new Article(no++, "제목1", "내용1", Util.getDateStr(), 10));

//		Article article = new Article(no++, "제목2", "내용2", Util.getDateStr(), 20);
//		articles.add(article);
//		Article article = new Article(no++, "제목2", "내용2", Util.getDateStr(), 20);
//		articles.add(article);
//		Article article = new Article(no++, "제목2", "내용2", Util.getDateStr(), 20);
//		articles.add(article);

	}

}




