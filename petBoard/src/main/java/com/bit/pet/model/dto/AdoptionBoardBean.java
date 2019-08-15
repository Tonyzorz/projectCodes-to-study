package com.bit.pet.model.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class AdoptionBoardBean {
	
	private int abNum;
	private String abTitle;
	private String abContent;
	private String abWriter;
	private String abKind;
	private int abAge;
	private String abGender;
	private String abPrice;
	private String abCategory;
	private Date abDate;
	private int abHit;
	private int abLike;
	private String abPicUrl;
	private MultipartFile files;
	
	public String getAbPicUrl() {
		return abPicUrl;
	}

	public void setAbPicUrl(String abPicUrl) {
		this.abPicUrl = abPicUrl;
	}

	public MultipartFile getFiles() {
		return files;
	}

	public void setFiles(MultipartFile files) {
		this.files = files;
	}

	public int getAbNum() {
		return abNum;
	}
	public void setAbNum(int abNum) {
		this.abNum = abNum;
	}
	public String getAbTitle() {
		return abTitle;
	}
	public void setAbTitle(String abTitle) {
		this.abTitle = abTitle;
	}
	public String getAbContent() {
		return abContent;
	}
	public void setAbContent(String abContent) {
		this.abContent = abContent;
	}
	public String getAbWriter() {
		return abWriter;
	}
	public void setAbWriter(String abWriter) {
		this.abWriter = abWriter;
	}
	public String getAbKind() {
		return abKind;
	}
	public void setAbKind(String abKind) {
		this.abKind = abKind;
	}
	public int getAbAge() {
		return abAge;
	}
	public void setAbAge(int abAge) {
		this.abAge = abAge;
	}
	public String getAbGender() {
		return abGender;
	}
	public void setAbGender(String abGender) {
		this.abGender = abGender;
	}
	public String getAbPrice() {
		return abPrice;
	}
	public void setAbPrice(String abPrice) {
		this.abPrice = abPrice;
	}
	public String getAbCategory() {
		return abCategory;
	}
	public void setAbCategory(String abCategory) {
		this.abCategory = abCategory;
	}
	public Date getAbDate() {
		return abDate;
	}
	public void setAbDate(Date abDate) {
		this.abDate = abDate;
	}
	public int getAbHit() {
		return abHit;
	}
	public void setAbHit(int abHit) {
		this.abHit = abHit;
	}
	public int getAbLike() {
		return abLike;
	}
	public void setAbLike(int abLike) {
		this.abLike = abLike;
	}

	@Override
	public String toString() {
		return "AdoptionBoardBean [abNum=" + abNum + ", abTitle=" + abTitle + ", abContent=" + abContent + ", abWriter="
				+ abWriter + ", abKind=" + abKind + ", abAge=" + abAge + ", abGender=" + abGender + ", abPrice="
				+ abPrice + ", abCategory=" + abCategory + ", abDate=" + abDate + ", abHit=" + abHit + ", abLike="
				+ abLike + ", abPicUrl=" + abPicUrl + ", files=" + files + "]";
	}

}
