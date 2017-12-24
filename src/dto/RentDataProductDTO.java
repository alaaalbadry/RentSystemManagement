package dto;

public class RentDataProductDTO {
	
	private Integer productID;
	private String productType;
	private Double productPrice;
	private Integer Item_ID;
	private Integer PRODUCT_ID;
	private Integer QR_CODE;
	private boolean RENT_STATUS;
	
	public RentDataProductDTO() {
		
	}
	
	public RentDataProductDTO(Integer productID) {
	
		this.productID = productID;
	}

	public RentDataProductDTO(Integer productID, String productType) {
		
		this.productID = productID;
		this.productType = productType;
	}

	public RentDataProductDTO(Integer productID, String productType, Double productPrice) {
		
		this.productID = productID;
		this.productType = productType;
		this.productPrice = productPrice;
	}

	public RentDataProductDTO(Integer productID, String productType, Double productPrice, Integer item_ID) {
		
		this.productID = productID;
		this.productType = productType;
		this.productPrice = productPrice;
		this.Item_ID = item_ID;
	}

	public RentDataProductDTO(Integer productID, String productType, Double productPrice, Integer item_ID, Integer pRODUCT_ID) {
	
		this.productID = productID;
		this.productType = productType;
		this.productPrice = productPrice;
		this.Item_ID = item_ID;
		this.PRODUCT_ID = pRODUCT_ID;
	}

	public RentDataProductDTO(Integer productID, String productType, Double productPrice, Integer item_ID, Integer pRODUCT_ID,
			Integer qR_CODE) {
		
		this.productID = productID;
		this.productType = productType;
		this.productPrice = productPrice;
		this.Item_ID = item_ID;
		this.PRODUCT_ID = pRODUCT_ID;
		this.QR_CODE = qR_CODE;
	}

	public RentDataProductDTO(Integer productID, String productType, Double productPrice, Integer item_ID, Integer pRODUCT_ID,
			Integer qR_CODE, boolean rENT_STATUS) {
		super();
		this.productID = productID;
		this.productType = productType;
		this.productPrice = productPrice;
		this.Item_ID = item_ID;
	this.PRODUCT_ID = pRODUCT_ID;
	this.QR_CODE = qR_CODE;
		this.RENT_STATUS = rENT_STATUS;
	}

	/**
	 * @return the productID
	 */
	public Integer getProductID() {
		return productID;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	/**
	 * @return the productType
	 */
	public String getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}

	/**
	 * @return the productPrice
	 */
	public Double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the item_ID
	 */
	public Integer getItem_ID() {
		return Item_ID;
	}

	/**
	 * @param item_ID the item_ID to set
	 */
	public void setItem_ID(Integer item_ID) {
		Item_ID = item_ID;
	}

	/**
	 * @return the pRODUCT_ID
	 */
	public Integer getPRODUCT_ID() {
		return PRODUCT_ID;
	}

	/**
	 * @param pRODUCT_ID the pRODUCT_ID to set
	 */
	public void setPRODUCT_ID(Integer pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}

	/**
	 * @return the qR_CODE
	 */
	public Integer getQR_CODE() {
		return QR_CODE;
	}

	/**
	 * @param qR_CODE the qR_CODE to set
	 */
	public void setQR_CODE(Integer qR_CODE) {
		QR_CODE = qR_CODE;
	}

	/**
	 * @return the rENT_STATUS
	 */
	public boolean getRENT_STATUS() {
		return RENT_STATUS;
	}

	/**
	 * @param rENT_STATUS the rENT_STATUS to set
	 */
	public void setRENT_STATUS(boolean rENT_STATUS) {
		RENT_STATUS = rENT_STATUS;
	}
	
	
	
	
	
	
	
	

}
