package com.wareHouse.service.Dtos;

public class InventoryDto {

	private int date;

	private int warehouseId;

	private int productId;

	private int DeliveryFromProduction;

	private int stock;

	private int reservation;

	private int backOrder;

	private int rejection;

	private int startUpLose;

	private int obsoletes;

	

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getDeliveryFromProduction() {
		return DeliveryFromProduction;
	}

	public void setDeliveryFromProduction(int deliveryFromProduction) {
		DeliveryFromProduction = deliveryFromProduction;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getReservation() {
		return reservation;
	}

	public void setReservation(int reservation) {
		this.reservation = reservation;
	}

	public int getBackOrder() {
		return backOrder;
	}

	public void setBackOrder(int backOrder) {
		this.backOrder = backOrder;
	}

	public int getRejection() {
		return rejection;
	}

	public void setRejection(int rejection) {
		this.rejection = rejection;
	}

	public int getStartUpLose() {
		return startUpLose;
	}

	public void setStartUpLose(int startUpLose) {
		this.startUpLose = startUpLose;
	}

	public int getObsoletes() {
		return obsoletes;
	}

	public void setObsoletes(int obsoletes) {
		this.obsoletes = obsoletes;
	}

	@Override
	public String toString() {
		return "InventoryEntity [date=" + date + ", warehouseId=" + warehouseId + ", productId=" + productId
				+ ", DeliveryFromProduction=" + DeliveryFromProduction + ", stock=" + stock + ", reservation="
				+ reservation + ", backOrder=" + backOrder + ", rejection=" + rejection + ", startUpLose=" + startUpLose
				+ ", obsoletes=" + obsoletes + "]";
	}

}
