package dao;


import java.util.ArrayList;
import java.util.List;

import dto.RentDataProductDTO;
import dto.RentProcessDTO;
import model.AccountModel;
import model.ProductModel;
import model.UserModel;

public interface IAccountDAO {
//CRUD
	public boolean createAccount(AccountModel accountModel) throws Exception;
	public boolean updateAccount(AccountModel accountModel)throws Exception;
	public boolean deleteAccountByNID(String accountNatID)throws Exception;
	public AccountModel getAccountByNID(String accountNID)throws Exception;
	public List<AccountModel> getAllAccounts();
	public boolean getLoginData(UserModel userModel)throws Exception;
	public boolean checkRentAccount(String accountNatID)throws Exception;
	public int getRentProductData(String productType)throws Exception;
	public ArrayList<RentProcessDTO> getReceipt(String accountNatID);
	ProductModel getProductData(String productType) throws Exception;
	List<RentDataProductDTO> getAvailableProducItems(String productType) throws Exception;
	public int inserRentProcessData(Integer itemId, String accountNID, int rentDuration, Double payedPrice) ;
	int rentItem(Integer itemId);
}
