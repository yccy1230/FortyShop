package com.pb.entity;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private OrderId id;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(OrderId id) {
		this.id = id;
	}

	// Property accessors

	public OrderId getId() {
		return this.id;
	}

	public void setId(OrderId id) {
		this.id = id;
	}

}