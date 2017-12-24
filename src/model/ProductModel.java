package model;

public class ProductModel {
	
	private Integer productId;
	private  String ProductType;
	private Double Productprice;
	private String Productstatus;
	private String ProductDescription;
	
	public ProductModel() {
		
	}
	public ProductModel(String productType) {
		
		ProductType = productType;
	}
	public ProductModel(String productType, Double productprice) {
		
		ProductType = productType;
		Productprice = productprice;
	}
	public ProductModel(String productType, Double productprice, String productstatus) {
		
		ProductType = productType;
		Productprice = productprice;
		Productstatus = productstatus;
	}
	public ProductModel(String productType, Double productprice, String productstatus, String productDescription) {
		
		ProductType = productType;
		Productprice = productprice;
		Productstatus = productstatus;
		ProductDescription = productDescription;
	}
	/**
	 * @return the productType
	 */
	public String getProductType() {
		return ProductType;
	}
	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		ProductType = productType;
	}
	/**
	 * @return the productprice
	 */
	public Double getProductprice() {
		return Productprice;
	}
	/**
	 * @param productprice the productprice to set
	 */
	public void setProductprice(Double productprice) {
		Productprice = productprice;
	}
	/**
	 * @return the productstatus
	 */
	public String getProductstatus() {
		return Productstatus;
	}
	/**
	 * @param productstatus the productstatus to set
	 */
	public void setProductstatus(String productstatus) {
		Productstatus = productstatus;
	}
	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return ProductDescription;
	}
	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	

}
