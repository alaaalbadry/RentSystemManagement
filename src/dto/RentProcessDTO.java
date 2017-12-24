package dto;

public class RentProcessDTO {
	private  int SDRent;
	private  int EDRent;
	private double payedPrice;
	private int Quantity;
	
	public RentProcessDTO() {
		
	}
	
	
	
	public RentProcessDTO(int sDRent) {
		
		this.SDRent = sDRent;
	}



	public RentProcessDTO(int sDRent,int eDRent) {
		
		this.SDRent = sDRent;
		this.EDRent = eDRent;
	}



	public RentProcessDTO(int sDRent, int eDRent, float payedPrice) {
		
		this.SDRent = sDRent;
		this.EDRent = eDRent;
		this.payedPrice = payedPrice;
	}



	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return Quantity;
	}



	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}



	/**
	 * @return the sDRent
	 */
	public int getSDRent() {
		return SDRent;
	}
	/**
	 * @param sDRent the sDRent to set
	 */
	public void setSDRent(int sDRent) {
		SDRent = sDRent;
	}
	/**
	 * @return the eDRent
	 */
	public int getEDRent() {
		return EDRent;
	}
	/**
	 * @param eDRent the eDRent to set
	 */
	public void setEDRent(int eDRent) {
		EDRent = eDRent;
	}
	/**
	 * @return the payedPrice
	 */
	public double getPayedPrice() {
		return payedPrice;
	}
	/**
	 * @param payedPrice the payedPrice to set
	 */
	public void setPayedPrice(double payedPrice) {
		this.payedPrice = payedPrice;
	}
	
	

}
