package com.pb.entity;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */

public class Item implements java.io.Serializable {

	// Fields

	private String itemId;
	private String coverImage;
	private String clothesName;
	private String clothesdetail;
	private String size;
	private Double price;
	private String remainNum;
	private String part;

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** full constructor */
	public Item(String coverImage, String clothesName, String clothesdetail,
			String size, Double price, String remainNum, String part) {
		this.coverImage = coverImage;
		this.clothesName = clothesName;
		this.clothesdetail = clothesdetail;
		this.size = size;
		this.price = price;
		this.remainNum = remainNum;
		this.part = part;
	}

	// Property accessors

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getCoverImage() {
		return this.coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getClothesName() {
		return this.clothesName;
	}

	public void setClothesName(String clothesName) {
		this.clothesName = clothesName;
	}

	public String getClothesdetail() {
		return this.clothesdetail;
	}

	public void setClothesdetail(String clothesdetail) {
		this.clothesdetail = clothesdetail;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemainNum() {
		return this.remainNum;
	}

	public void setRemainNum(String remainNum) {
		this.remainNum = remainNum;
	}

	public String getPart() {
		return this.part;
	}

	public void setPart(String part) {
		this.part = part;
	}

}