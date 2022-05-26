package com.wareHouse.service.Dtos;

public class OrderLineDto {
	private int orderLineNumber;

	private int orderHeaderId;

	private int itemId;

	private int quantity;

	private float unitPrice;

	private String shipTo;

	private String lineStatus;

	private String promisedDate;

	public int getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	public int getOrderHeaderId() {
		return orderHeaderId;
	}

	public void setOrderHeaderId(int orderHeaderId) {
		this.orderHeaderId = orderHeaderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getShipTo() {
		return shipTo;
	}

	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}

	public String getLineStatus() {
		return lineStatus;
	}

	public void setLineStatus(String lineStatus) {
		this.lineStatus = lineStatus;
	}

	public String getPromisedDate() {
		return promisedDate;
	}

	public void setPromisedDate(String promisedDate) {
		this.promisedDate = promisedDate;
	}

	@Override
	public String toString() {
		return "OrderLineDto [orderLineNumber=" + orderLineNumber + ", orderHeaderId=" + orderHeaderId + ", itemId="
				+ itemId + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", shipTo=" + shipTo
				+ ", lineStatus=" + lineStatus + ", promisedDate=" + promisedDate + "]";
	}
	
	

}
