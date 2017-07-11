package com.pb.entity;

/**
 * CartId entity. @author MyEclipse Persistence Tools
 */

public class CartId implements java.io.Serializable {

	// Fields

	private String userId;
	private String itemId;
	private String num;
	private String money;
	private String size;
	private String status;

	// Constructors

	/** default constructor */
	public CartId() {
	}

	/** full constructor */
	public CartId(String userId, String itemId, String num, String money,
			String size, String status) {
		this.userId = userId;
		this.itemId = itemId;
		this.num = num;
		this.money = money;
		this.size = size;
		this.status = status;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getMoney() {
		return this.money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CartId))
			return false;
		CartId castOther = (CartId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getItemId() == castOther.getItemId()) || (this
						.getItemId() != null && castOther.getItemId() != null && this
						.getItemId().equals(castOther.getItemId())))
				&& ((this.getNum() == castOther.getNum()) || (this.getNum() != null
						&& castOther.getNum() != null && this.getNum().equals(
						castOther.getNum())))
				&& ((this.getMoney() == castOther.getMoney()) || (this
						.getMoney() != null && castOther.getMoney() != null && this
						.getMoney().equals(castOther.getMoney())))
				&& ((this.getSize() == castOther.getSize()) || (this.getSize() != null
						&& castOther.getSize() != null && this.getSize()
						.equals(castOther.getSize())))
				&& ((this.getStatus() == castOther.getStatus()) || (this
						.getStatus() != null && castOther.getStatus() != null && this
						.getStatus().equals(castOther.getStatus())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getItemId() == null ? 0 : this.getItemId().hashCode());
		result = 37 * result
				+ (getNum() == null ? 0 : this.getNum().hashCode());
		result = 37 * result
				+ (getMoney() == null ? 0 : this.getMoney().hashCode());
		result = 37 * result
				+ (getSize() == null ? 0 : this.getSize().hashCode());
		result = 37 * result
				+ (getStatus() == null ? 0 : this.getStatus().hashCode());
		return result;
	}

}