package com.bit.pet.model.dto;

public class AbFileAttachmentBean {

	private int imageNum;
	private int abNum;
	private String fileName;
	
	@Override
	public String toString() {
		return "AbFileAttachmentBean [imageNum=" + imageNum + ", abNum=" + abNum + ", fileName=" + fileName + "]";
	}
	public int getImageNum() {
		return imageNum;
	}
	public void setImageNum(int imageNum) {
		this.imageNum = imageNum;
	}
	public int getAbNum() {
		return abNum;
	}
	public void setAbNum(int abNum) {
		this.abNum = abNum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
