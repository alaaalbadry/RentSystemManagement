package dao;

import java.util.ArrayList;
import java.util.List;

import dto.RentDataProductDTO;
import dto.RentProcessDTO;
import model.ProductModel;

public interface IRentProcessDAO {
	
	public boolean checkRentAccount(String accountNatID)throws Exception;
	public int getRentProductData(String productType)throws Exception;
	public ArrayList<RentProcessDTO> getReceipt(String accountNatID);
	ProductModel getProductData(String productType) throws Exception;
	List<RentDataProductDTO> getAvailableProducItems(String productType) throws Exception;
	public int inserRentProcessData(Integer itemId, String accountNID, int rentDuration, Double payedPrice) ;
	int rentItem(Integer itemId);
	
	

}
