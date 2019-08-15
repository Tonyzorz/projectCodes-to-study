package com.bit.pet.model.dto;


public class AdoptionBoardCommentBean {

	private int abcNum;
	private int abcRef;
	private String abcWriter;
	private String abcContent;
	private String abcDate;
	@Override
	public String toString() {
		return "AdoptionBoardCommentBean [abcNum=" + abcNum + ", abcRef=" + abcRef + ", abcWriter=" + abcWriter
				+ ", abcContent=" + abcContent + ", abcDate=" + abcDate + "]";
	}
	public int getAbcNum() {
		return abcNum;
	}
	public void setAbcNum(int abcNum) {
		this.abcNum = abcNum;
	}
	public int getAbcRef() {
		return abcRef;
	}
	public void setAbcRef(int abcRef) {
		this.abcRef = abcRef;
	}
	public String getAbcWriter() {
		return abcWriter;
	}
	public void setAbcWriter(String abcWriter) {
		this.abcWriter = abcWriter;
	}
	public String getAbcContent() {
		return abcContent;
	}
	public void setAbcContent(String abcContent) {
		this.abcContent = abcContent;
	}
	public String getAbcDate() {
		return abcDate;
	}
	public void setAbcDate(String abcDate) {
		this.abcDate = abcDate;
	}
	
	
}
