package com.woori.BAM.dto; 

public class Article {
    // alt + shift + a --> toogle key (멀티 편집)
	// getter / setter 생성, 타이핑 최소화 
	private int id;
	private String regDate;
	private String title;
	private String body;
	private int viewCnt;
	
	
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	// 순서 수정 
	public Article(int id, String regDate, String title, String body, int viewCnt) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
		this.viewCnt = viewCnt;
	}
	
	public void increaseViewCnt() {
		this.viewCnt++;
	}
}