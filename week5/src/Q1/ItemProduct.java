package Q1;

import java.io.Serializable;

public class ItemProduct implements Serializable {
	
	// Declaration of attributes
	private int itemProductID;
	private String name;
	private float price;
	
	/**
	 * @return the itemProductID
	 */
	public int getItemProductID() {
		return itemProductID;
	}
	
	/**
	 * @param itemProduct the itemProduct to set
	 */
	public void setItemProductID(int itemProductID) {
		this.itemProductID = itemProductID;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	

}