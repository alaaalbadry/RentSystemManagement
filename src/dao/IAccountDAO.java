package dao;



import java.util.List;
import model.AccountModel;



public interface IAccountDAO {
//CRUD
	public boolean createAccount(AccountModel accountModel) throws Exception;
	public boolean updateAccount(AccountModel accountModel)throws Exception;
	public boolean deleteAccountByNID(String accountNatID)throws Exception;
	public AccountModel getAccountByNID(String accountNID)throws Exception;
	public List<AccountModel> getAllAccounts();
	
	
	
}
