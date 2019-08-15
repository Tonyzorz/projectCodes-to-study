package com.bit.pet.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class JournalBoardBean {
	private int jbNum;
	private String jbTitle;
	private String jbContent;
	private String jbWriter;
	private String jbDate;
	private int jbHit;
	private int jbLike;
	private int jbGroup;
	private int jbStep;
	private int jbIndent;
	private String jbPicUrl;
	private MultipartFile files;
	
	public String getJbPicUrl() {
		return jbPicUrl;
	}
	public void setJbPicUrl(String jbPicUrl) {
		this.jbPicUrl = jbPicUrl;
	}
	public MultipartFile getFiles() {
		return files;
	}
	public void setFiles(MultipartFile files) {
		this.files = files;
	}
	public int getJbNum() {
		return jbNum;
	}
	public void setJbNum(int jbNum) {
		this.jbNum = jbNum;
	}
	public String getJbTitle() {
		return jbTitle;
	}
	public void setJbTitle(String jbTitle) {
		this.jbTitle = jbTitle;
	}
	public String getJbContent() {
		return jbContent;
	}
	public void setJbContent(String jbContent) {
		this.jbContent = jbContent;
	}
	public String getJbWriter() {
		return jbWriter;
	}
	public void setJbWriter(String jbWriter) {
		this.jbWriter = jbWriter;
	}
	public String getJbDate() {
		return jbDate;
	}
	public void setJbDate(String jbDate) {
		this.jbDate = jbDate;
	}
	public int getJbHit() {
		return jbHit;
	}
	public void setJbHit(int jbHit) {
		this.jbHit = jbHit;
	}
	public int getJbLike() {
		return jbLike;
	}
	public void setJbLike(int jbLike) {
		this.jbLike = jbLike;
	}
	public int getJbGroup() {
		return jbGroup;
	}
	public void setJbGroup(int jbGroup) {
		this.jbGroup = jbGroup;
	}
	public int getJbStep() {
		return jbStep;
	}
	public void setJbStep(int jbStep) {
		this.jbStep = jbStep;
	}
	public int getJbIndent() {
		return jbIndent;
	}
	public void setJbIndent(int jbIndent) {
		this.jbIndent = jbIndent;
	}
	@Override
	public String toString() {
		return "JournalBoardBean [jbNum=" + jbNum + ", jbTitle=" + jbTitle + ", jbContent=" + jbContent + ", jbWriter="
				+ jbWriter + ", jbDate=" + jbDate + ", jbHit=" + jbHit + ", jbLike=" + jbLike + ", jbGroup=" + jbGroup
				+ ", jbStep=" + jbStep + ", jbIndent=" + jbIndent + ", jbPicUrl=" + jbPicUrl + ", files=" + files + "]";
	}
	
	
	
}
