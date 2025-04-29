package com.woori.BAM.dto;

public class Article {
	private String title;
	private String body;
	private String date;
	private int viewCount;

	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}


	public Article(int id, String title, String body, String date, int viewCount) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.date = date;
		this.viewCount = viewCount;
	}

	public void incViewCount() {
		this.viewCount++;
	}

}