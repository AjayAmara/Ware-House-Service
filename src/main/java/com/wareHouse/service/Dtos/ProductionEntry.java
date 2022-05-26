package com.wareHouse.service.Dtos;

public class ProductionEntry {
	
	private String stockDate;
	private int warehouseId;
	private int productId;
	private int deliveryFromProduction;
	private int rejection;
	private int startUpLose;


	public String getStockDate() {
		return stockDate;
	}
	public void setStockDate(String stockDate) {
		this.stockDate = stockDate;
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
		return deliveryFromProduction;
	}
	public void setDeliveryFromProduction(int deliveryFromProduction) {
		this.deliveryFromProduction = deliveryFromProduction;
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
	@Override
	public String toString() {
		return "ProductionEntry [stockDate=" + stockDate + ", warehouseId=" + warehouseId + ", productId=" + productId
				+ ", DeliveryFromProduction=" + deliveryFromProduction + ", rejection=" + rejection + ", startUpLose="
				+ startUpLose + "]";
	}
	
	
	

}
