package com.wareHouse.service.Dtos;

public class OrderHeaderDto {

	private int orderId;

	private String orderDate;

	private int customerId;

	private String salesChannel;

	private String orderStatus;

	public OrderHeaderDto() {
		super();
	}

	public OrderHeaderDto(int orderId, String orderDate, int customerId, String salesChannel, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerId = customerId;
		this.salesChannel = salesChannel;
		this.orderStatus = orderStatus;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderHeaderEntity [orderId=" + orderId + ", orderDate=" + orderDate + ", customerId=" + customerId
				+ ", salesChannel=" + salesChannel + ", orderStatus=" + orderStatus + "]";
	}

}
