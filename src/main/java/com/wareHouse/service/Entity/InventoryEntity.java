package com.wareHouse.service.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class InventoryEntity {
	
	@Id
	@Column(name = "inv_no")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sNo;
	
	@Column(name = "stock_date")
	private int stockDate;
	
	@Column(name = "warehouse_id")
	private int warehouseId;
	
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "Delivery_from_production")
	private int deliveryFromProduction;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "reservation")
	private int reservation;
	
	@Column(name = "back_order")
	private int backOrder;
	
	@Column(name = "rejection")
	private int rejection;
	
	@Column(name = "start_up_lose")
	private int startUpLose;
	
	@Column(name = "obsoletes")
	private int obsoletes;
	
	

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	

	

	public int getStockDate() {
		return stockDate;
	}

	public void setStockDate(int stockDate) {
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
		return "InventoryEntity [sNo=" + sNo + ", stockDate=" + stockDate + ", warehouseId=" + warehouseId
				+ ", productId=" + productId + ", DeliveryFromProduction=" + deliveryFromProduction + ", stock=" + stock
				+ ", reservation=" + reservation + ", backOrder=" + backOrder + ", rejection=" + rejection
				+ ", startUpLose=" + startUpLose + ", obsoletes=" + obsoletes + "]";
	}

	

	
	

}
