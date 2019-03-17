package shafiq.ur.rehman.menu.model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.NumberFormat;

public class MenuItem implements Comparable<MenuItem>, Serializable{
	private static final long serialVersionUID = 1L;
	
	private int itemNo;
	private String itemDesc;
	private double itemPrice;
	private int quantity;
	
	public MenuItem() {
		super();
	}
	public MenuItem(int itemNo, String itemDesc, double itemPrice ) {
		this.setItemNo(itemNo);
		this.setItemDesc(itemDesc);
		this.setItemPrice(itemPrice);
		this.setQuantity(0);
	}
	
	public int getItemNo() {
		return itemNo;
	}
	
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	
	public String getItemDesc() {
		return itemDesc;
	}
	
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	public double getItemPrice() {
		return itemPrice;
	}
	
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
    public String toString () {
    	ByteArrayOutputStream bs = new ByteArrayOutputStream();
    	PrintStream ps = new PrintStream(bs);
    	ps.printf("%4s     %-30s", getItemNo(), getItemDesc());
    	String s = bs.toString();
    	NumberFormat nf = NumberFormat.getCurrencyInstance();
    	return s + nf.format( getItemPrice() );
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemDesc == null) ? 0 : itemDesc.hashCode());
		result = prime * result + itemNo;
		long temp;
		temp = Double.doubleToLongBits(itemPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (itemDesc == null) {
			if (other.itemDesc != null)
				return false;
		} else if (!itemDesc.equals(other.itemDesc))
			return false;
		if (itemNo != other.itemNo)
			return false;
		if (Double.doubleToLongBits(itemPrice) != Double.doubleToLongBits(other.itemPrice))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(MenuItem mi) {
		return getItemNo() - mi
				.getItemNo();
	}

}
