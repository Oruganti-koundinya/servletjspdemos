package com.samples.domain;

public class Chapter {
	private int chapterNumber;
	private String title;
	
	public Chapter(int chapterNumber, String title) {
		super();
		this.chapterNumber = chapterNumber;
		this.title = title;
	}
	public int getChapterNumber() {
		return chapterNumber;
	}
	public void setChapterNumber(int chapterNumber) {
		this.chapterNumber = chapterNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Chapter [chapterNumber=" + chapterNumber + ", title=" + title + "]";
	}
}
