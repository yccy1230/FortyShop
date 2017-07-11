package com.pb.entity;

import java.sql.Timestamp;

/**
 * OrderId entity. @author MyEclipse Persistence Tools
 */

public class OrderId implements java.io.Serializable {

	// Fields

	private String orderId;
	private String userId;
	private String coverImage;
	private String orderDetail;
	private String orderStatus;
	private Timestamp orderDate;
	private String totalMoney;

	// Constructors

	/** default constructor */
	public OrderId() {
	}

	/** full constructor */
	public OrderId(String orderId, String userId, String coverImage,
			String orderDetail, String orderStatus, Timestamp orderDate,
			String totalMoney) {
		this.orderId = orderId;
		this.userId = userId;
		this.coverImage = coverImage;
		this.orderDetail = orderDetail;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.totalMoney = totalMoney;
	}

	// Property accessors

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCoverImage() {
		return this.coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getOrderDetail() {
		return this.orderDetail;
	}

	public void setOrderDetail(String orderDetail) {
		this.orderDetail = orderDetail;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getTotalMoney() {
		return this.totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderId))
			return false;
		OrderId castOther = (OrderId) other;

		return ((this.getOrderId() == castOther.getOrderId()) || (this
				.getOrderId() != null && castOther.getOrderId() != null && this
				.getOrderId().equals(castOther.getOrderId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getCoverImage() == castOther.getCoverImage()) || (this
						.getCoverImage() != null
						&& castOther.getCoverImage() != null && this
						.getCoverImage().equals(castOther.getCoverImage())))
				&& ((this.getOrderDetail() == castOther.getOrderDetail()) || (this
						.getOrderDetail() != null
						&& castOther.getOrderDetail() != null && this
						.getOrderDetail().equals(castOther.getOrderDetail())))
				&& ((this.getOrderStatus() == castOther.getOrderStatus()) || (this
						.getOrderStatus() != null
						&& castOther.getOrderStatus() != null && this
						.getOrderStatus().equals(castOther.getOrderStatus())))
				&& ((this.getOrderDate() == castOther.getOrderDate()) || (this
						.getOrderDate() != null
						&& castOther.getOrderDate() != null && this
						.getOrderDate().equals(castOther.getOrderDate())))
				&& ((this.getTotalMoney() == castOther.getTotalMoney()) || (this
						.getTotalMoney() != null
						&& castOther.getTotalMoney() != null && this
						.getTotalMoney().equals(castOther.getTotalMoney())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOrderId() == null ? 0 : this.getOrderId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37
				* result
				+ (getCoverImage() == null ? 0 : this.getCoverImage()
						.hashCode());
		result = 37
				* result
				+ (getOrderDetail() == null ? 0 : this.getOrderDetail()
						.hashCode());
		result = 37
				* result
				+ (getOrderStatus() == null ? 0 : this.getOrderStatus()
						.hashCode());
		result = 37 * result
				+ (getOrderDate() == null ? 0 : this.getOrderDate().hashCode());
		result = 37
				* result
				+ (getTotalMoney() == null ? 0 : this.getTotalMoney()
						.hashCode());
		return result;
	}

}